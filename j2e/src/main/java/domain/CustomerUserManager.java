package domain;

import entities.CustomerUser;
import entities.Shop;

import java.util.List;

/**
 * Created by user on 03/04/2015.
 */
public interface CustomerUserManager extends UserManager {

    void changeloyaltyProgram(CustomerUser user, boolean loyalty);
    void changeloyaltyProgram(String email, boolean loyalty);

    void changeGiftCardCredit(CustomerUser user, double gift);
    void changeGiftCardCredit(String email, double gift);

    void changePreferateShop(CustomerUser user, Shop preferate);
    void changePreferateShop(String email, Shop preferate);

    List<CustomerUser> findAllCustomerUsers();

    void changeCreditCard(String email, Long creditCard);
    void changeCreditCard(CustomerUser user, Long creditCard);
}