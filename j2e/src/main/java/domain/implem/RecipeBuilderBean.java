package domain.implem;

import domain.RecipeBuilder;
import entities.*;

import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Interceptors(UserOrder.class)
public class RecipeBuilderBean implements RecipeBuilder {
	// parfum maximum autorisee
	private static final int MAX_TOPPINGS = 3;

	public static int getMaxToppings() {
		return MAX_TOPPINGS;
	}

	@PersistenceContext
	EntityManager em;

	@Override
	public List<Recipe> findAll() {
		return em.createQuery("select object(o) from Recipe as o")
				.getResultList();
	}

	@Override
	public void removeRecipe(Recipe r) {
		em.remove(em.merge(r));
	}

	/**
	 * Persistance de notre recette après verification de l'ensemble de ses
	 * paramètres & du calcul de son prix HT
	 * 
	 * @param pR recette personnelle que l'on souhaite creer
	 */
	@Override
	public void createPersonalRecipe(PersonalRecipe pR) {
		this.validatePersonalRecipe(pR);
		this.computePersonalRecipeDutyFreePrice(pR);
		em.persist(pR);
	}

	/**
	 * Calcul prix HT d'une recette personnelle aucune verification sur les
	 * paramètres de la recette la verification a été faite en amont lors de sa
	 * création
	 * 
	 * @param pR recette personelle dont on souhaite calculer le
	 *            prix HT
	 */
	private void computePersonalRecipeDutyFreePrice(PersonalRecipe pR) {
		double dutyFreePrice = 0.0;
		dutyFreePrice += pR.getDough().getPrice();
		dutyFreePrice += pR.getCooking().getPrice();
		dutyFreePrice += pR.getMix().getPrice();
		if (pR.getFlavour() != null)
			dutyFreePrice += pR.getFlavour().getPrice();
		for (Topping t : pR.getTopping())
			dutyFreePrice += t.getPrice();

		pR.setDutyFreePrice(dutyFreePrice);
	}

	/**
	 * Valider une recette générale.
	 * 
	 * @param recipe recette a valider
	 */
	private void validateRecipe(Recipe recipe) {
		if (recipe.getName() == null)
			throw new EJBException("A recipe must have a name.");
	}

	/**
	 * Valider une recette client.
	 * 
	 * @param pR  recette personnelle a verifier
	 */
	private void validatePersonalRecipe(PersonalRecipe pR) {
		this.validateRecipe(pR);

		List<Topping> topping = pR.getTopping();

		if (pR.getDough() == null)
			throw new EJBException("A personal recipe must have a dough.");
		if (pR.getMix() == null)
			throw new EJBException("A personal recipe must have a mix.");
		if (pR.getCooking() == null)
			throw new EJBException("A personal recipe must have a cooking.");
		if (topping.size() > getMaxToppings())
			throw new EJBException("A personal recipe can't have more than " + RecipeBuilderBean.getMaxToppings() + " toppings.");
	}

	/**
	 * @param pR Recette personnelle a valider avant d'être mise à jour.
	 */
	@Override
	public void updatePersonalRecipe(PersonalRecipe pR) {
		this.validatePersonalRecipe(pR);
		this.computePersonalRecipeDutyFreePrice(pR);
		em.merge(pR);
	}

	@Override
	public PersonalRecipe findPersonalRecipe(Object id) {
		return em.find(PersonalRecipe.class, id);
	}

	@Override
	public List<PersonalRecipe> findPersonalRecipesByUser(String email) {
		List<Recipe> recipes = findAll();
		List<PersonalRecipe> filteredRecipes = new ArrayList<>();
		for (Recipe r : recipes) {
			if ((r instanceof PersonalRecipe) && ((PersonalRecipe) r).getUser()!=null && ((PersonalRecipe) r).getUser().getEmail().equals(email))
				filteredRecipes.add((PersonalRecipe) r);
		}
		return filteredRecipes;
	}

	@Override
	public void removePersonalRecipe(PersonalRecipe pR) {
		em.remove(em.merge(pR));
	}

	@Override
	public void createShopRecipe(ShopRecipe sR) {
		this.validateRecipe(sR);
		em.persist(sR);
	}

	@Override
	public void updateShopRecipe(ShopRecipe sR) {
		this.validateRecipe(sR);
		em.merge(sR);
	}

	@Override
	public ShopRecipe findShopRecipe(Object id) {
		return em.find(ShopRecipe.class, id);
	}

	@Override
	public List<ShopRecipe> findAllShopRecipe() {
		List<Recipe> recipes = findAll();
		List<ShopRecipe> filteredRecipes = new ArrayList<>();
		for (Recipe r : recipes) {
			if ((r instanceof ShopRecipe))
				filteredRecipes.add((ShopRecipe) r);
		}
		return filteredRecipes;
	}

	@Override
	public void removeShopRecipe(ShopRecipe sR) {
		em.remove(em.merge(sR));
	}

	/**
	 * trouver ensemble recette peronnelle d'un client
	 * 
	 * @param customer client dont on souhaite les recettes personnelles.
	 * @return List<PersonalRecipe> liste des recettes personnelles du client.
	 */
	public List<PersonalRecipe> findByCustomerUser(CustomerUser customer) {
		Query query = em
				.createNativeQuery("SELECT * FROM PERSONAL_RECIPE WHERE PERSONAL_RECIPE.USER_EMAIL = :email");
		query.setParameter("email", customer.getEmail());
		return (List<PersonalRecipe>) query.getResultList();
	}
}
