package domain.implem;

import domain.CustomerUserManager;
import domain.OrderBuilder;
import domain.RecipeBuilder;
import domain.ShopManager;
import entities.*;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Arquillian.class)
public class OrderBuilderBeanTest {
    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap
                .create(WebArchive.class, "test.war")
                .addPackage(UserOrder.class.getPackage())
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsWebInfResource("META-INF/persistence.xml",
                        "persistence.xml")
                .addPackage(OrderBuilder.class.getPackage())
                .addPackage(OrderBuilderBean.class.getPackage());
    }

	@EJB
	private OrderBuilder orderBean;
	@EJB
	private CustomerUserManager customerUserBean;
	@EJB
	private ShopManager shopBean;
	@EJB
	private RecipeBuilder recipeBean;
	private UserOrder orderA, orderB, orderC;
	private CustomerUser cuA, cuB;
	private Shop shopA, shopB;
	private ShopRecipe sR1, sR2, sR3, sR4;

	@Test
	public void testCreateOrder() {
		assertEquals(orderA.getId() + 1, orderB.getId(), 0);
		assertEquals(orderA.getId() + 2, orderC.getId(), 0);
	}

	@Test
	public void testFindAll() {
		assertEquals(3, orderBean.findAll().size());
	}

	@Test
	public void testFindAllShop() throws Exception {
		assertEquals(1, orderBean.getOrdersByShop(shopA).size());
		assertEquals(2, orderBean.getOrdersByShop(shopB).size());
	}

	@Test
	public void testProducts() throws Exception {
		assertEquals(3, orderBean.findAll().size());
		assertEquals(2, orderBean.findAll().get(0).getProducts().size());
	}

	@Before
	public void setUp() throws Exception {
		Address adA = new Address("France", "MArly-Gomont", 02120, ""), adB = new Address(
				"Dysney", "RainbowDashTown", 777, "");

		cuA = new CustomerUser("mailA@default.com", "Arthur", "Hamam");
		cuB = new CustomerUser("mailB@default.com", "Bernard", "Bromure");

		customerUserBean.createUser(cuA,"password");
		customerUserBean.createUser(cuB,"password");

		shopA = new Shop(12.0, 50, 250, adA);
		shopB = new Shop(20.0, 1000, 100, adB);

		shopBean.createShop(shopA);
		shopBean.createShop(shopB);


		orderA=new UserOrder();
		orderA.setShop(shopA);
		orderB=new UserOrder();
		orderB.setUser(cuA);
		orderB.setShop(shopB);
		orderC=new UserOrder();
		orderC.setUser(cuB);
		orderC.setShop(shopB);

		sR1 = new ShopRecipe();
		sR1.setName("Shop Recipe 1");
		sR1.setDutyFreePrice(30.0);
		sR1.setIsMenu(true);

		sR2 = new ShopRecipe();
		sR2.setName("Shop Recipe 2");
		sR2.setDutyFreePrice(25.0);
		sR2.setIsMenu(true);

		sR4 = new ShopRecipe();
		sR4.setName("Shop Recipe 3");
		sR4.setDutyFreePrice(20.0);
		sR4.setIsMenu(true);

		sR3 = new ShopRecipe();
		sR3.setName("Shop Recipe 4");
		sR3.setDutyFreePrice(15.0);
		sR3.setIsMenu(true);

		recipeBean.createShopRecipe(sR1);
		recipeBean.createShopRecipe(sR2);
		recipeBean.createShopRecipe(sR3);
		recipeBean.createShopRecipe(sR4);

		ArrayList<Product> list1 = new ArrayList<Product>(),list2 = new ArrayList<>(),list3=new ArrayList<>();
		Product p1 = new Product();
		p1.setRecipe(sR1);
		p1.setQuantity(2);
		//orderBean.createProduct(p1);
		list1.add(p1);

		Product p2 = new Product();
		p2.setRecipe(sR2);
		p2.setQuantity(3);
		//orderBean.createProduct(p2);
		list1.add(p2);

		Product p3 = new Product();
		p3.setRecipe(sR3);
		p3.setQuantity(5);
		//orderBean.createProduct(p3);
		list2.add(p3);

		Product p4 = new Product();
		p4.setRecipe(sR4);
		p4.setQuantity(14);
		//orderBean.createProduct(p4);
		list3.add(p4);

		Product p5 = new Product();
		p5.setRecipe(sR1);
		p5.setQuantity(0);
		//orderBean.createProduct(p5);
		list3.add(p5);

		orderA.setProducts(list1);
		orderB.setProducts(list2);
		orderC.setProducts(list3);

		orderA.setDate(new Date());
		orderB.setDate(new Date());
		orderC.setDate(new Date());

		orderBean.createOrder(orderA, new Long(1234));
		System.out.println("###A - " + orderBean.findOrder(orderA.getId()));
		orderBean.createOrder(orderB, new Long(1234));
		orderBean.createOrder(orderC,new Long(1234));

	}

	@After
	public void tearDown() throws Exception {
		List<UserOrder> orders = orderBean.findAll();
		for (UserOrder order : orders) {
			orderBean.remove(order.getId());
			System.out.println("remove" + order);
		}

		List<User> users = customerUserBean.findAll();
		for (User u : users) {
			customerUserBean.removeUser(u);
			System.out.println("remove" + u);
		}

		List<Shop> shops = shopBean.findAll();
		for (Shop shop : shops) {
			shopBean.remove(shop);
			System.out.println("remove" + shop);
		}

	}

}
