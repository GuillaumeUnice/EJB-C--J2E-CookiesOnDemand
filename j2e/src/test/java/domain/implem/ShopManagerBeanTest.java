package domain.implem;

import domain.ShopManager;
import domain.UserManager;
import entities.Address;
import entities.Shop;
import entities.ShopUser;
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

import static org.junit.Assert.*;

/**
 * Created by Maxime Dito.
 */

@RunWith(Arquillian.class)
public class ShopManagerBeanTest {

	@Deployment
	public static Archive<?> createDeployment() {
		return ShrinkWrap
				.create(WebArchive.class, "test.war")
				.addPackage(Shop.class.getPackage())
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
				.addAsWebInfResource("META-INF/persistence.xml",
						"persistence.xml")
				.addPackage(ShopManager.class.getPackage())
				.addPackage(ShopManagerBean.class.getPackage());
	}

    private Shop testShop;
    private Long testShopId;

	@EJB
	private ShopManager manager;
    @EJB
    private UserManager uManager;

    @Before
    public void before(){
        testShop=new Shop(20.0,60,30,new Address("Tesland","emptyTown",12345,""));
        manager.createShop(testShop);
        testShopId = testShop.getId();
    }

    @After
    public void after() {
        for (Shop s : manager.findAll()) {
            manager.remove(s);
        }
    }

    @Test
    public void testCreateA() throws Exception {
        Shop p = manager.createShop();
        Long ref = p.getId();
        assertEquals(ref,p.getId(),0);
        p = manager.createShop();
        assertEquals(ref+1,p.getId(),0);
        p = manager.createShop();
        assertEquals(ref + 2, p.getId(), 0);
    }

    @Test
    public void testCreateB() throws Exception {
        Shop p = new Shop();
        assertNull(p.getId());
        manager.createShop(p);
        assertNotNull(p.getId());
    }

	@Test
	public void testChangeTax() throws Exception {
        manager.changeTaxe(testShop, 20);
        assertEquals(20, manager.find(testShopId).getTaxe(), 0);

        manager.changeTaxe(testShopId, 25);
        assertEquals(25, manager.find(testShopId).getTaxe(), 0);
	}

    @Test
    public void testChangeNbMaxCustomer() throws Exception{
        manager.changeNbMaxCustomer(testShop, 20);
        assertEquals(20, manager.find(testShopId).getNbMaxCustomer(), 0);


        manager.changeNbMaxCustomer(testShopId, 25);
        assertEquals(25, manager.find(testShopId).getNbMaxCustomer(), 0);
    }

    @Test
    public void testChangeNbMaxCookie() throws Exception{
        manager.changeNbMaxCookie(testShop, 20);
        assertEquals(20, manager.find(testShopId).getNbMaxCookie(), 0);

        manager.changeNbMaxCookie(testShopId, 25);
        assertEquals(25, manager.find(testShopId).getNbMaxCookie(), 0);
    }

    @Test
    public void testChangeAddress() throws Exception{
        Address ad = new Address();
        assertNotEquals(ad, manager.find(testShopId).getAddress());
        manager.changeAddress(testShop, ad);
        assertEquals(ad, manager.find(testShopId).getAddress());

        ad = new Address("France","MArly-Gomont",02120,"");
        assertNotEquals(ad, manager.find(testShopId).getAddress());
        manager.changeAddress(testShopId, ad);
        assertEquals(ad, manager.find(testShopId).getAddress());
    }

    @Test
    public void testShopUser() throws Exception {
        ShopUser su = new ShopUser("myMail","myName","myName");
        manager.changeShopUser(testShop,su);
        assertEquals(((ShopUser) uManager.findUser("myMail")).getManagedShop(), manager.find(testShopId));
        Shop newShop = new Shop(1.0,1,1,new Address());
        manager.createShop(newShop);
        manager.changeShopUser(newShop,su);
        assertEquals(((ShopUser) uManager.findUser("myMail")).getManagedShop(), manager.find(newShop.getId()));

    }


}