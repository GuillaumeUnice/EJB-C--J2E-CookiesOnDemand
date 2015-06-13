package webservice;

import domain.OrderBuilder;
import domain.ShopManager;
import domain.UserManager;
import entities.Shop;
import entities.ShopUser;
import entities.User;
import entities.UserOrder;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

/**
 * Created by Tom Veniat on 12/04/15.
 */

@WebService(targetNamespace = "http://www.polytech.unice.fr/si/4a/appserv/demos")
@Stateless(name = "ShopService")
public class ShopImpl implements ShopWs{
    @EJB
    private ShopManager shopManagerBean;
    @EJB
    private UserManager userManagerBean;
    @EJB
    private OrderBuilder orderManagerBean;


    @Override
    @WebMethod
    public Shop getShopByShopUser(User user) {
        ShopUser shopUser = getShopUser(user.getEmail());
        if (shopUser != null)
            return shopManagerBean.find(shopUser.getManagedShop().getId());
        return null;

    }

    public ShopUser getShopUser(String mail) {
        User tempUser = userManagerBean.findUser(mail);
        ShopUser shopUser = null;
        if (tempUser instanceof ShopUser)
            shopUser=(ShopUser)tempUser;
        return shopUser;
    }


    @Override
    public List<UserOrder> getAllOrdersbyShop(Long id) {
        return orderManagerBean.getOrdersByShop(shopManagerBean.find(id));
    }

    @Override
    public void changeShopUser(Long shopId, String shopUserEmail) {
        Shop shop = shopManagerBean.find(shopId);
        if (shop==null) return;

        ShopUser shopUser= getShopUser(shopUserEmail);
        if (shopUser==null) return;

        shopManagerBean.changeShopUser(shop, shopUser);
    }

}
