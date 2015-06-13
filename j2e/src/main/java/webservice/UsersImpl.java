package webservice;

import domain.*;
import entities.*;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;



@WebService(targetNamespace = "http://www.polytech.unice.fr/si/4a/appserv/demos")
@Stateless(name = "UsersService")
public class UsersImpl implements UsersWs {

    @EJB
    private ShopManager shopManagerBean;
    @EJB
    private CustomerUserManager custoUserManagerBean;
    @EJB
    private UserManager userManagerBean;
    @EJB
    private OrderBuilder orderManagerBean;
    @EJB
    private RecipeBuilder recipeBuilderBean;


    @Override
    @WebMethod
    @Interceptors(AdminAuthInterceptor.class)
    public void createShop(Address add, int maxClients, int maxCookies, double taxe, String user, String password) {
        shopManagerBean.createShop(new Shop(taxe, maxCookies, maxClients, add));
    }

    @Override
    @WebMethod
    public void deleteShop(Long id) {
        shopManagerBean.remove(shopManagerBean.find(id));
    }

    @Override
    @WebMethod
    public Shop getShopById(int id) {
        return shopManagerBean.find(id);
    }

    @Override
    @WebMethod
    public List<Shop> getAllShops() {
        return shopManagerBean.findAll();
    }

    @Override
    @WebMethod
    public List<User> getAllUsers() {
        return userManagerBean.findAll();
    }

    @Override
    public void removeUser(User user) {
        userManagerBean.removeUser(user);
    }

    @Override
    @WebMethod
    public List<CustomerUser> getAllCustomerUsers() {
        return custoUserManagerBean.findAllCustomerUsers();
    }

    @Override
    @WebMethod
    public void createCustomerUser(String email, String firstName, String lastName,String password) {
        CustomerUser u = new CustomerUser(email, firstName, lastName);
        custoUserManagerBean.createUser(u,password);
    }

    @Override
    @WebMethod
    @Interceptors(AuthInterceptor.class)
    public CustomerUser getCustomerUserById(String email,String password) {
        System.out.println("CAALLLLLLLLLL");
        User user = custoUserManagerBean.findUser(email);
        if (user instanceof CustomerUser) return (CustomerUser)user;
        return null;
    }

    @Override
    @WebMethod
    @Interceptors(AuthInterceptor.class)
    public void changeFavoriteShop(Long id, String email,String password) {
        Shop newShop = shopManagerBean.find(id);
        custoUserManagerBean.changePreferateShop(email, newShop);
    }

    @Override
    @Interceptors(AuthInterceptor.class)
    public void changCreditCard(Long creditCard,String email, String password) {
        custoUserManagerBean.changeCreditCard(email, creditCard);
    }

    @Override
    @WebMethod
    public List<ShopUser> getAllShopUsers() {
        return userManagerBean.findAllShopUsers();
    }

    @Override
    @WebMethod
    public void createShopUser(String email, String firstName, String lastName, String password) {
        User u = new ShopUser(email,firstName,lastName);
        userManagerBean.createUser(u, password);
    }

    @Override
    @WebMethod
    public ShopUser getShopUserById(String email) {
        User user = custoUserManagerBean.findUser(email);
        if (user instanceof ShopUser) return (ShopUser)user;
        return null;
    }

    @Override
    @WebMethod
    public Long createOrder(UserOrder order,Long creditCard) {
        orderManagerBean.createOrder(order, creditCard);
        return order.getId();
    }

    @Override
    public List<UserOrder> getAllOrders() {
        return orderManagerBean.findAll();
    }

    @Override
    public List<UserOrder> getUserOrders(String email) {
        return orderManagerBean.getOrdersByUser(email);
    }

    @Override
    public Long createShopRecipe(ShopRecipe recipe) {
        recipeBuilderBean.createShopRecipe(recipe);
        return recipe.getId();
    }

    @Override
    public void removeRecipe(Recipe recipe) {
        recipeBuilderBean.removeRecipe(recipe);
    }

    @Override
    public Long createPersonalRecipe(PersonalRecipe recipe) {
        recipeBuilderBean.createPersonalRecipe(recipe);
        return recipe.getId();
    }

    @Override
    public void updatePersonalRecipe(PersonalRecipe recipe) {
        recipeBuilderBean.updatePersonalRecipe(recipe);
    }

    @Override
    public List<Recipe> getAllRecipes() {
        return recipeBuilderBean.findAll();
    }

    @Override
    public List<ShopRecipe> getAllShopRecipes() {
        return recipeBuilderBean.findAllShopRecipe();
    }

    @Override
    public List<PersonalRecipe> getAllRecipesByUser(CustomerUser customerUser) {
        return recipeBuilderBean.findPersonalRecipesByUser(customerUser.getEmail());
    }

    @Override
    public Dough[] getAllDoughs() {
        return Dough.values();
    }

    @Override
    public Flavour[] getAllFlavours() {
        return Flavour.values();
    }

    @Override
    public Mix[] getAllMixs() {
        return Mix.values();
    }

    @Override
    public Cooking[] getAllCookings() {
        return Cooking.values();
    }

    @Override
    public Topping[] getAllToppings() {
        return Topping.values();
    }

}
