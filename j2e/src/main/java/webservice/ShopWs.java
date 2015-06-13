package webservice;

import entities.Shop;
import entities.User;
import entities.UserOrder;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.List;

/**
 * Created by Tom Veniat on 12/04/15.
 */

@WebService
public interface ShopWs {
    @WebMethod
    @WebResult(name = "Shop")
    public Shop getShopByShopUser(@WebParam(name = "User") User user);

    @WebMethod
    @WebResult(name = "ShopOrders")
    public List<UserOrder> getAllOrdersbyShop(Long id);

    @WebMethod
    @WebResult(name = "ShopUserChanged")
    public void changeShopUser(Long shopId, String shopUserEmail);


}
