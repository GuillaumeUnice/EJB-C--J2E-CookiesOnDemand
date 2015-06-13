
package webservice;

import domain.AdminAuthInterceptor;
import entities.*;

import javax.interceptor.Interceptor;
import javax.interceptor.Interceptors;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.List;

/**
 * Created by Tom Veniat on 07/04/15.
 */
@WebService
public interface UsersWs {


    @WebMethod
    @WebResult(name = "shopCreated")
    public void createShop(@WebParam(name = "Location") Address add,
                           @WebParam(name = "MaxClientsNumber") int maxClients,
                           @WebParam(name = "MaxCookiesNumber") int maxCookies,
                           @WebParam(name = "Taxe") double taxe,
                           @WebParam(name = "id") String email,
                           @WebParam(name = "password") String password);

    @WebMethod
    @WebResult(name = "shopDeleted")
    public void deleteShop(@WebParam(name = "id") Long id);

    @WebMethod
    @WebResult(name = "Shop")
    public Shop getShopById(@WebParam(name = "ident") int ID);

    @WebMethod
    @WebResult(name = "Shops")
    public List<Shop> getAllShops();

    @WebMethod
    @WebResult(name = "Users")
    public List<User> getAllUsers();

    @WebMethod
    @WebResult(name = "UserDeleted")
    public void removeUser(@WebParam(name = "user")User user);

    @WebMethod
    @WebResult(name = "CustomerUsers")
    public List<CustomerUser> getAllCustomerUsers();

    @WebMethod
    @WebResult(name = "UserCreated")
    public void createCustomerUser(@WebParam(name = "email") String email,
                                   @WebParam(name = "firstNane") String firstName,
                                   @WebParam(name = "lastName") String lastName,
                                   @WebParam(name = "password") String password);

    @WebMethod
    @WebResult(name = "CustomerUser")
    public CustomerUser getCustomerUserById(@WebParam(name = "id") String email,
                                            @WebParam(name = "password") String password);

    @WebMethod
    @WebResult(name = "FavoriteShopChanged")
    public void changeFavoriteShop(@WebParam(name = "newFavouriteShopId") Long id,
                                   @WebParam(name = "userId") String email,
                                   @WebParam(name = "password") String password);

    @WebMethod
    @WebResult(name = "CreditCardChanged")
    public void changCreditCard(@WebParam(name = "newCreditCardNumber") Long creditCard,
                                @WebParam(name = "userId") String email,
                                @WebParam(name = "password") String password);

    @WebMethod
    @WebResult(name = "ShopUsers")
    public List<ShopUser> getAllShopUsers();

    @WebMethod
    @WebResult(name = "ShopUserCreated")
    public void createShopUser(@WebParam(name = "email") String email,
                               @WebParam(name = "firstNane") String firstName,
                               @WebParam(name = "lastName") String lastName,
                               @WebParam(name = "password") String password);

    @WebMethod
    @WebResult(name = "ShopUser")
    public ShopUser getShopUserById(@WebParam(name = "id") String email);

    @WebMethod
    @WebResult(name = "OrderCreated")
    public Long createOrder(@WebParam(name = "order")UserOrder order,
                            @WebParam(name = "creditCard")Long creditCard);

    @WebMethod
    @WebResult(name = "AllOrders")
    public List<UserOrder> getAllOrders();

    @WebMethod
    @WebResult(name = "OrderCreated")
    public List<UserOrder> getUserOrders(@WebParam(name = "user")String email);

    @WebMethod
    @WebResult(name = "ShopRecipeCreated")
    public Long createShopRecipe(@WebParam(name = "ShopRecipe")ShopRecipe recipe);

    @WebMethod
    @WebResult(name = "RecipeDeleted")
    public void removeRecipe(@WebParam(name = "Recipe")Recipe recipe);

    @WebMethod
    @WebResult(name = "PersonalRecipeCreated")
    public Long createPersonalRecipe(@WebParam(name = "PersonalRecipe")PersonalRecipe recipe);

    @WebMethod
    @WebResult(name = "PersonalRecipeUpdated")
    public void updatePersonalRecipe(@WebParam(name = "PersonalRecipe")PersonalRecipe recipe);

    @WebMethod
    @WebResult(name = "AllRecipes")
    public List<Recipe> getAllRecipes();

    @WebMethod
    @WebResult(name = "AllShopRecipes")
    public List<ShopRecipe> getAllShopRecipes();

    @WebMethod
    @WebResult(name = "OneUserRecipes")
    public List<PersonalRecipe> getAllRecipesByUser(@WebParam(name = "user")CustomerUser customerUser);

    @WebMethod
    @WebResult(name = "Doughs")
    public Dough[] getAllDoughs();

    @WebMethod
    @WebResult(name = "Flavours")
    public Flavour[] getAllFlavours();

    @WebMethod
    @WebResult(name = "Mixs")
    public Mix[] getAllMixs();

    @WebMethod
    @WebResult(name = "Cookings")
    public Cooking[] getAllCookings();

    @WebMethod
    @WebResult(name = "Toppings")
    public Topping[] getAllToppings();


}
