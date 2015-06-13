package domain.implem;

import domain.CustomerUserManager;
import domain.ShopManager;
import entities.Address;
import entities.CustomerUser;
import entities.Shop;
import entities.User;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(Arquillian.class)
public class CustomerUserBeanTest {

    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap
                .create(WebArchive.class, "test.war")
                .addPackage(User.class.getPackage())
                .addPackage(CustomerUser.class.getPackage())
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsWebInfResource("META-INF/persistence.xml",
                        "persistence.xml")
                .addPackage(CustomerUserManager.class.getPackage())
                .addPackage(CustomerUserBean.class.getPackage());
    }

    @Before
    public void before() {
        p = new CustomerUser("francis.cabrel@gmail.com", "Francis", "Cabrel");
        manager.createUser(p,"password");
        p2 = new CustomerUser("edouard.stark@gmail.com", "Ned", "Stark");
        manager.createUser(p2,"password");
    }

    @After
    public void after() {
        manager.removeUser(p);
        manager.removeUser(p2);
    }

    @EJB
    private CustomerUserManager manager;
    @EJB
    private ShopManager shopManager;
    private CustomerUser p;
    private CustomerUser p2;

    @Test
    public void testCreateCustomerUser() throws Exception {
        assertEquals("francis.cabrel@gmail.com",p.getEmail());
        assertEquals("edouard.stark@gmail.com",p2.getEmail());
    }

    @Test
    public void testChangeloyaltyProgram() throws Exception {
        manager.changeloyaltyProgram(p, true);
        assertEquals(p.isLoyaltyProgram(), ((CustomerUser)manager.findUser("francis.cabrel@gmail.com")).isLoyaltyProgram());

        manager.changeloyaltyProgram("francis.cabrel@gmail.com", false);
        assertEquals(false, ((CustomerUser)manager.findUser("francis.cabrel@gmail.com")).isLoyaltyProgram());
    }

    @Test
    public void testChangeGiftCardCredit() throws Exception {
        manager.changeGiftCardCredit(p, 20);
        assertEquals(p.getGiftCardCredit(), ((CustomerUser)manager.findUser("francis.cabrel@gmail.com")).getGiftCardCredit(), 0);

        manager.changeGiftCardCredit("francis.cabrel@gmail.com", 25);
        assertEquals(25, ((CustomerUser)manager.findUser("francis.cabrel@gmail.com")).getGiftCardCredit(), 0);
    }

    @Test
    public void testChangePreferateShop() throws Exception {
        Shop myShop = new Shop(20.0, 20, 50, new Address("Oregon", "Salt Lake City", 06600, "Chez moi"));
        shopManager.createShop(myShop);
        assertNotEquals(myShop, ((CustomerUser) manager.findUser("francis.cabrel@gmail.com")).getFavouriteShop());
        manager.changePreferateShop(p, myShop);
        assertEquals(p.getFavouriteShop(), ((CustomerUser) manager.findUser("francis.cabrel@gmail.com")).getFavouriteShop());
        assertEquals(myShop, ((CustomerUser)manager.findUser("francis.cabrel@gmail.com")).getFavouriteShop());
    }
}