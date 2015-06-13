package domain;

import entities.ShopUser;
import entities.User;

import java.util.List;

/**
 * Created by user on 03/04/2015.
 */
public interface UserManager {

    public void createUser(User user, String password);

    public void removeUser(User user);

    public User findUser(String email);

    public List<User> findAll();

    public List<ShopUser> findAllShopUsers();

    public void changeEmail(User user, String email);

    public void changeFirstName(User user, String firstname);

    public void changeLastName(User user, String lastname);
}
