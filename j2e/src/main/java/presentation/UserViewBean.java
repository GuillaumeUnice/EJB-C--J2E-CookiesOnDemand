package presentation;


/**
 * Created by Tom Veniat on 10/05/15.
 */

import domain.Authentifier;
import domain.OrderBuilder;
import domain.ShopManager;
import domain.UserManager;
import entities.ShopUser;
import entities.User;
import entities.UserOrder;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@RequestScoped
public class UserViewBean implements Serializable{

    @EJB
    private UserManager userManagerBean;
    @EJB
    private ShopManager shopManagerBean;
    @EJB
    private OrderBuilder orderBuilderBean;
    @EJB
    private Authentifier authentifierBean;

    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public User getUser(String email){

        User u = userManagerBean.findUser(email);
        if ((u instanceof ShopUser)) return (ShopUser)u;

        return null;
    }

    public List<ShopUser> getShopUsers(){
        return userManagerBean.findAllShopUsers();
    }

    public List<UserOrder> getOrdersByShopUser(){
        User u = userManagerBean.findUser(email);
        if (!(u instanceof ShopUser)) return new ArrayList<>();
        ShopUser usr = (ShopUser)u;
        if (authentifierBean.connect(email,password))
            return orderBuilderBean.getOrdersByShop(usr.getManagedShop());
        else return new ArrayList<>();
    }
}
