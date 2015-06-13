package domain.implem;

import domain.ShopManager;
import entities.Address;
import entities.Shop;
import entities.ShopUser;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Tom Veniat on 24/03/15.
 */
@Stateless
public class ShopManagerBean implements ShopManager {

	@PersistenceContext
	EntityManager em;

	@Override
	public Shop createShop() {
		Shop shop = new Shop();
		em.persist(shop);
		return shop;
	}

	@Override
	public void createShop(Shop shop) {
		em.persist(shop);
	}


	@Override
	public Shop find(Object id) {
		return em.find(Shop.class, id);
	}

	@Override
	public void remove(Shop shop) { em.remove(em.merge(shop));
	}

	@Override
	public List<Shop> findAll() {
		return em.createQuery("select object(o) from Shop as o")
				.getResultList();
	}

    @Override
    public void changeTaxe(Shop shop, double taxe) {
        shop.setTaxe(taxe);
        em.merge(shop);
    }

    @Override
    public void changeTaxe(Long id, double taxe) {
        changeTaxe(find(id), taxe);
    }

    @Override
    public void changeNbMaxCustomer(Shop shop, int nb) {
        shop.setNbMaxCustomer(nb);
        em.merge(shop);
    }

    @Override
    public void changeNbMaxCustomer(Long id, int nb) {
        changeNbMaxCustomer(find(id), nb);
    }

    @Override
    public void changeNbMaxCookie(Shop shop, int nb) {
        shop.setNbMaxCookie(nb);
        em.merge(shop);
    }

    @Override
    public void changeNbMaxCookie(Long id, int nb) {
        changeNbMaxCookie(find(id), nb);
    }

    @Override
    public void changeAddress(Shop shop, Address address) {
        shop.setAddress(address);
        em.merge(shop);
    }

    @Override
    public void changeAddress(Long id, Address address) {
        changeAddress(find(id), address);
    }



    @Override
    public void changeShopUser(Shop testShop, ShopUser su) {
        su.setManagedShop(testShop);
        em.merge(su);
    }

    @PostConstruct
	public void initialize() {
		System.out.println("Initializing ShopManager");
	}

	@PreDestroy
	public void cleanup() {
		System.out.println("Destroying ShopManager");
	}
}