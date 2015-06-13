package domain;

import entities.PersonalRecipe;
import entities.Recipe;
import entities.ShopRecipe;

import java.util.List;

public interface RecipeBuilder {

	List<Recipe> findAll();

	void removeRecipe(Recipe r);

	public void createPersonalRecipe(PersonalRecipe pR);

	public void updatePersonalRecipe(PersonalRecipe pR);

	public PersonalRecipe findPersonalRecipe(Object id);

	List<PersonalRecipe> findPersonalRecipesByUser(String email);

	public void removePersonalRecipe(PersonalRecipe pR);

	void createShopRecipe(ShopRecipe sR);

	void updateShopRecipe(ShopRecipe sR);

	ShopRecipe findShopRecipe(Object id);

	List<ShopRecipe> findAllShopRecipe();

	void removeShopRecipe(ShopRecipe sR);
}
