package domain.implem;

import domain.CustomerUserManager;
import domain.RecipeBuilder;
import entities.*;
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
import javax.ejb.EJBException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Arquillian.class)
public class RecipeBuilderBeanTest {
	@Deployment
	public static Archive<?> createDeployment() {
		return ShrinkWrap
				.create(WebArchive.class, "test.war")
				.addPackage(PersonalRecipe.class.getPackage())
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
				.addAsWebInfResource("META-INF/persistence.xml",
						"persistence.xml")
				.addPackage(RecipeBuilder.class.getPackage())
				.addPackage(RecipeBuilderBean.class.getPackage());

	}


	@EJB
	private RecipeBuilder manager;
	@EJB
	private CustomerUserManager userManager;

	private PersonalRecipe pR1, pR2;
	private ShopRecipe sR1, sR2, sR3, sR4;


	@Before
	public void before() {
		pR1 = new PersonalRecipe();
		pR1.setName("MyPersonalRecipe");
		pR1.setDough(Dough.Chocolate);
		pR1.setMix(Mix.Mixed);
		pR1.setCooking(Cooking.Crunchy);
		List<Topping> toppings =new ArrayList<>();
		toppings.add(Topping.MilkChocolate);
		pR1.setTopping(toppings);
		manager.createPersonalRecipe(pR1);

		pR2 = new PersonalRecipe();
		pR2.setName("MyNewPersonalRecipe");
		pR2.setDough(Dough.PeanutButter);
		pR2.setMix(Mix.Topped);
		pR2.setCooking(Cooking.Chewy);
		ArrayList<Topping> topping = new ArrayList<Topping>();
		topping.add(Topping.MilkChocolate);
		topping.add(Topping.ReeseButtercup);
		topping.add(Topping.MMS);
		pR2.setTopping(topping);

		manager.createPersonalRecipe(pR2);

		sR1 = new ShopRecipe();
		sR1.setName("Shop Recipe 1");
		sR1.setDutyFreePrice(30.0);
		sR1.setIsMenu(true);

		sR2 = new ShopRecipe();
		sR2.setName("Shop Recipe 2");
		sR2.setDutyFreePrice(25.0);
		sR2.setIsMenu(true);

		sR4 = new ShopRecipe();
		sR4.setName("Shop Recipe 3");
		sR4.setDutyFreePrice(20.0);
		sR4.setIsMenu(true);

		sR3 = new ShopRecipe();
		sR3.setName("Shop Recipe 4");
		sR3.setDutyFreePrice(15.0);
		sR3.setIsMenu(true);


		manager.createShopRecipe(sR1);
		manager.createShopRecipe(sR2);
		manager.createShopRecipe(sR3);
		manager.createShopRecipe(sR4);

	}

	@After
	public void after(){
		for (Recipe r : manager.findAll())
			manager.removeRecipe(r);
	}

	@Test
	public void testCreatePersonalRecipe() {
		PersonalRecipe pR1 = new PersonalRecipe();
		pR1.setName("MyNewPersonalRecipe");
		pR1.setDough(Dough.Chocolate);
		pR1.setMix(Mix.Mixed);
		pR1.setCooking(Cooking.Crunchy);
		ArrayList<Topping> topping = new ArrayList<Topping>();
		topping.add(Topping.MilkChocolate);
		topping.add(Topping.ReeseButtercup);
		pR1.setTopping(topping);

		manager.createPersonalRecipe(pR1);

		assertEquals(pR1, manager.findPersonalRecipe(pR1.getId()));

	}

	@Test(expected = EJBException.class)
	public void testPersonalRecipeNotNameNullable() {
		pR1.setName(null);
		manager.updatePersonalRecipe(pR1);
	}

	@Test
	public void testPersonalRecipeDutyFreePriceA() {
		double expectedDutyFreePrice = 0.0;
		expectedDutyFreePrice += pR2.getDough().getPrice();
		expectedDutyFreePrice += pR2.getCooking().getPrice();
		expectedDutyFreePrice += pR2.getMix().getPrice();
		if (pR2.getFlavour() != null)
			expectedDutyFreePrice += pR2.getFlavour().getPrice();
		for (Topping t : pR2.getTopping()) {
			expectedDutyFreePrice += t.getPrice();
		}

		assertEquals(expectedDutyFreePrice, pR2.getDutyFreePrice(), 0.001);
	}

	@Test
	public void testPersonalRecipeDutyFreePriceB() {
		List<Topping> toppings = new ArrayList<>();
		pR1.setTopping(toppings);
		manager.updatePersonalRecipe(pR1);

		double expectedDutyFreePrice = 0.0;
		expectedDutyFreePrice += pR1.getDough().getPrice();
		expectedDutyFreePrice += pR1.getCooking().getPrice();
		expectedDutyFreePrice += pR1.getMix().getPrice();
		if (pR1.getFlavour() != null)
			expectedDutyFreePrice += pR1.getFlavour().getPrice();

		assertEquals(expectedDutyFreePrice, pR1.getDutyFreePrice(), 0.001);

		toppings.add(Topping.ReeseButtercup);
		pR1.setTopping(toppings);
		manager.updatePersonalRecipe(pR1);

		expectedDutyFreePrice += Topping.ReeseButtercup.getPrice();

		assertEquals(expectedDutyFreePrice, pR1.getDutyFreePrice(),0.001);
	}

	@Test(expected = EJBException.class)
	public void testPersonalRecipeNotDoughNullable() {
		pR1.setDough(null);
		manager.updatePersonalRecipe(pR1);
	}

	@Test(expected = EJBException.class)
	public void testPersonalRecipeNotCookingNullable() {
		pR1.setCooking(null);
		manager.updatePersonalRecipe(pR1);
	}

	@Test(expected = EJBException.class)
	public void testPersonalRecipeMixNotNullable() {
		pR1.setMix(null);
		manager.updatePersonalRecipe(pR1);
	}


	@Test
	public void testPersonalRecipeCondMaxToppingsA() {
		ArrayList<Topping> topping = new ArrayList<Topping>();
		topping.add(Topping.MMS);
		topping.add(Topping.WhiteChocolate);
		topping.add(Topping.ReeseButtercup);

		pR1.setTopping(topping);

		manager.updatePersonalRecipe(pR1);
	}

	@Test(expected = EJBException.class)
	public void testPersonalRecipeCondMaxToppingsB() {
		ArrayList<Topping> topping = new ArrayList<Topping>();
		topping.add(Topping.MMS);
		topping.add(Topping.WhiteChocolate);
		topping.add(Topping.ReeseButtercup);
		topping.add(Topping.MilkChocolate);

		pR1.setTopping(topping);

		manager.updatePersonalRecipe(pR1);

	}

	@Test
	public void testUpdatePersonalRecipe() {

		pR1.setDough(Dough.PeanutButter);

		manager.updatePersonalRecipe(pR1);
		assertEquals(pR1.getDough(), manager.findPersonalRecipe(pR1.getId())
				.getDough());

	}

	@Test
	public void testRemovePersonalRecipe() {

		PersonalRecipe pR1 = new PersonalRecipe();
		pR1.setName("MyPersonalRecipe");
		pR1.setDough(Dough.Chocolate);
		pR1.setMix(Mix.Mixed);
		pR1.setCooking(Cooking.Crunchy);
		ArrayList<Topping> topping = new ArrayList<Topping>();
		topping.add(Topping.MilkChocolate);
		pR1.setTopping(topping);

		manager.createPersonalRecipe(pR1);

		assertEquals(pR1, manager.findPersonalRecipe(pR1.getId()));

		manager.removePersonalRecipe(pR1);
		assertEquals(null, manager.findPersonalRecipe(pR1.getId()));

	}

	@Test
	public void testCreateShopRecipe() {

		ShopRecipe sR = new ShopRecipe();
		sR.setName("ShopRecipe");
		sR.setDutyFreePrice(20.0);
		manager.createShopRecipe(sR);

		assertEquals(sR, manager.findShopRecipe(sR.getId()));

	}

	@Test
	public void testUpdateShopRecipe() {

		ShopRecipe sR = new ShopRecipe();
		sR.setName("ShopRecipe");
		sR.setDutyFreePrice(20.0);
		manager.createShopRecipe(sR);
		assertEquals(sR, manager.findShopRecipe(sR.getId()));

		sR.setIsMenu(true);
		sR.setDutyFreePrice(30.0);
		manager.updateShopRecipe(sR);
		assertEquals(sR, manager.findShopRecipe(sR.getId()));

	}

	@Test
	public void testRemoveShopRecipe() {

		ShopRecipe sR = new ShopRecipe();
		sR.setName("ShopRecipe");
		sR.setDutyFreePrice(20.0);
		manager.createShopRecipe(sR);
		assertEquals(sR, manager.findShopRecipe(sR.getId()));

		manager.removeShopRecipe(sR);
		assertEquals(null, manager.findShopRecipe(sR.getId()));
	}

	@Test
	public void testFindAll() throws Exception{

		assertEquals(6,manager.findAll().size());

	}

	@Test
	public void testFindAllShopRecipe() throws Exception{
		assertEquals(4,manager.findAllShopRecipe().size());

	}

	@Test
	public void testFindAllByUser() throws Exception{
		CustomerUser cu1 = new CustomerUser("emailA","Paul","Pot");
		CustomerUser cu2 = new CustomerUser("emailB","COu", "coU");

		userManager.createUser(cu1,"password");
		userManager.createUser(cu2,"password");


		pR1.setUser(cu2);
		pR2.setUser(cu2);

		manager.updatePersonalRecipe(pR1);
		manager.updatePersonalRecipe(pR2);

		assertEquals(0, manager.findPersonalRecipesByUser(cu1.getEmail()).size());
		assertEquals(2, manager.findPersonalRecipesByUser(cu2.getEmail()).size());

		PersonalRecipe pR3 = new PersonalRecipe();
		pR3.setDough(Dough.PeanutButter);
		pR3.setMix(Mix.Topped);
		pR3.setCooking(Cooking.Crunchy);
		pR3.setFlavour(Flavour.Chili);
		pR3.setTopping(new ArrayList<Topping>());
		pR3.setName("pr3");
		manager.createPersonalRecipe(pR3);
		pR3.setUser(cu1);
		manager.updatePersonalRecipe(pR3);

		assertEquals(1, manager.findPersonalRecipesByUser(cu1.getEmail()).size());

	}
}
