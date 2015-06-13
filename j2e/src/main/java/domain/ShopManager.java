package domain;

import entities.Address;
import entities.Shop;
import entities.ShopUser;

import java.util.List;

/**
 * Created by Tom Veniat on 24/03/15.
 */


public interface ShopManager {
	public Shop createShop();

	public void createShop(Shop shop);

	Shop find(Object id);

	void remove(Shop shop);

	List<Shop> findAll();

    public void changeTaxe(Shop shop, double taxe);
    public void changeTaxe(Long id, double taxe);

    public void changeNbMaxCustomer(Shop shop, int nb);
    public void changeNbMaxCustomer(Long id, int nb);

    public void changeNbMaxCookie(Shop shop, int nb);
    public void changeNbMaxCookie(Long id, int nb);

    public void changeAddress(Shop shop, Address address);
    public void changeAddress(Long id, Address address);

    void changeShopUser(Shop testShop, ShopUser su);
}
