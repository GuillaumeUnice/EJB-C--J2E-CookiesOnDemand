package domain.implem;

import UserAndPayment.IUserAndPaymentService;
import UserAndPayment.UserAndPaymentService;
import domain.UserManager;
import entities.ShopUser;
import entities.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.ws.BindingProvider;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 03/04/2015.
 */

@Stateless
public class UserManagerBean implements UserManager {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void createUser(User user, String password) {


        String address = "http://localhost:50828/UserAndPaymentService.svc";
        URL wsdlLocation = null;
        try {
            wsdlLocation = new URL(address + "?wsdl");
        } catch (Exception e) { System.exit(0); }
        UserAndPaymentService us = new UserAndPaymentService(wsdlLocation);
        IUserAndPaymentService userWs = us.getBasicHttpBindingIUserAndPaymentService();
        ((BindingProvider) userWs).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, address);
        //TODO CREER UN NOUVEL UTILISATEUR DOTNET
        userWs.addUser(user.getEmail(),password);
        //DotNEt.createUser(user.getEmail(),password);
        entityManager.persist(user);
    }

    @Override
    public void removeUser(User user) {
        entityManager.remove(entityManager.merge(user));
    }

    @Override
    public User findUser(String email) {
        return entityManager.find(User.class, email);
    }

    @Override
    public List<User> findAll() {
        return entityManager.createQuery("select object(o) from User as o")
                .getResultList();
    }

    @Override
    public List<ShopUser> findAllShopUsers() {
        List<User> users = findAll();
        List<ShopUser> managers = new ArrayList<ShopUser>();
        for (User u : users) {
            if (u instanceof ShopUser)
                managers.add((ShopUser) u);
            System.out.println(u);
        }
        return managers;
    }

    @Override
    public void changeEmail(User user, String email) {
        user.setEmail(email);
        entityManager.merge(user);
    }

    @Override
    public void changeFirstName(User user, String firstname) {
        user.setFirstName(firstname);
        entityManager.merge(user);
    }

    @Override
    public void changeLastName(User user, String lastname) {
        user.setLastName(lastname);
        entityManager.merge(user);
    }
}