package domain.implem;

import UserAndPayment.IUserAndPaymentService;
import UserAndPayment.UserAndPaymentService;
import domain.OrderBuilder;
import entities.CustomerUser;
import entities.Product;
import entities.Shop;
import entities.UserOrder;

import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.ws.BindingProvider;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Stateless
public class OrderBuilderBean implements OrderBuilder {

	@PersistenceContext
	EntityManager em;

	@Override
	public void createProduct(Product p) {
		em.persist(p);
	}

	@Override
	public List<UserOrder> getOrdersByUser(String email) {
		List<UserOrder> orders = findAll();

		List<UserOrder> filteredOrders = new ArrayList<UserOrder>();
		for (UserOrder order : orders)
			if (order.getUser()!=null && order.getUser().getEmail().equals(email))
				filteredOrders.add(order);

		return filteredOrders;	}


	@Override
	public void createOrder(UserOrder order, Long creditCard) {
        if (order.getUser()!= null)
            order.setUser(em.find(CustomerUser.class,order.getUser().getEmail()));
		this.validateOrder(order);
		//TODO Validation par la carte de crédit.
		String address = "http://localhost:50828/UserAndPaymentService.svc";
		URL wsdlLocation = null;
		try {
			wsdlLocation = new URL(address + "?wsdl");
		} catch (Exception e) { System.exit(0); }
		UserAndPaymentService us = new UserAndPaymentService(wsdlLocation);
		IUserAndPaymentService userWs = us.getBasicHttpBindingIUserAndPaymentService();
		((BindingProvider) userWs).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, address);
		if(creditCard>0) {
			em.persist(order);
			if (!userWs.addPayment(order.getId(),(order.getUser()==null)?null:order.getUser().getEmail(),creditCard.intValue()))
				em.remove(order);
		}
		System.out.println(order);
	}

	@Override
	public UserOrder findOrder(Long id) {
		UserOrder uo = em.find(UserOrder.class, id);

		return uo;
	}




	/**
	 * @param s Shop we will focus on.
	 * @return List<UserOrder> liste des commandes du magasin
	 */
	@Override
	public List<UserOrder> getOrdersByShop(Shop s) {
		@SuppressWarnings("unchecked")
		List<UserOrder> orders = findAll();

		Shop wantedShop = em.find(Shop.class, s.getId());

		List<UserOrder> filteredOrders = new ArrayList<UserOrder>();
		for (UserOrder order : orders)
			if (order.getShop().equals(wantedShop))
				filteredOrders.add(order);

		return filteredOrders;
	}

	@Override
	public List<UserOrder> getBillByShopAndDate(Shop s, Calendar date) {
		return null;

	}

	@Override
	public void remove(Object id) {
		em.remove(em.find(UserOrder.class, id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserOrder> findAll() {
		return em.createQuery("select object(o) from UserOrder as o")
				.getResultList();
	}

	@Override
	public void addProduct(List<Product> newProducts, UserOrder order) {
		List<Product> products = order.getProducts();
		products.addAll(newProducts);
		order.setProducts(products);
		em.merge(order);
	}

	@Override
	public void addProduct(Product p, UserOrder order) {
		List<Product> products = order.getProducts();
		products.add(p);
		order.setProducts(products);
		em.merge(order);
	}

	/**
	 * @param order
	 *            UserOrder commande sur laquelle on calcul le prix total
	 * @return double prix total TTC
	 */
	@Override
	public double makeBill(UserOrder order) {
		double totalPrice = 0.0;
/*		for (Product p : order.getProducts()) {
			totalPrice += p.getRecipe().getPreTaxePrice()
					+ (p.getRecipe().getPreTaxePrice() * (order.getShop()
							.getTaxe() / 100.0));
		}*/
		return totalPrice;
	}

	/**
	 * verification des paramêtre de la commande.
	 * 
	 * @param order commande à valider
	 */
	public void validateOrder(UserOrder order) {
		if (order.getShop() == null)
			throw new EJBException("An order MUST have a shop");
		if (order.getDate() == null)
			throw new EJBException("An order MUST have a date");

		List<Product> emptyProducts = new ArrayList<>();
		int nbCookies=0;
		for (Product p : order.getProducts()){
			if (p.getQuantity()==0) {
				emptyProducts.add(p);
				System.out.println("removing product.");
			}
			else nbCookies+=p.getQuantity();
		}
		order.getProducts().removeAll(emptyProducts);

		if (order.getProducts() == null || order.getProducts().size() == 0)
			throw new EJBException("An order MUST have at least one cookie.");
		else System.out.println("cookies ok : " + order.getProducts().size() + " products for a total of " + nbCookies + "cookies.");
	}
}
