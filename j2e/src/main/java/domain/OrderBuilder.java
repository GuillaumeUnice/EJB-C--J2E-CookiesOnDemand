package domain;

import entities.*;

import java.util.Calendar;
import java.util.List;

public interface OrderBuilder {

	public void createOrder(UserOrder order, Long crediCard);

	// public void addProduct(Product p, UserOrder order);

	// public void addRecipe(Product p, Recipe r, int quantity);

	public UserOrder findOrder(Long id);

	public List<UserOrder> getOrdersByShop(Shop s);

	public List<UserOrder> getBillByShopAndDate(Shop s, Calendar date);

	void remove(Object id);

	public List<UserOrder> findAll();

	void addProduct(Product p, UserOrder order);

	double makeBill(UserOrder order);

	void addProduct(List<Product> p, UserOrder order);

	void createProduct(Product p);

	List<UserOrder> getOrdersByUser(String email);

}
