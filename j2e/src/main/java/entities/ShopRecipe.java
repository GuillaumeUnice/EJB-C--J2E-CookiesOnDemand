package entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "SHOP_RECIPE")
@DiscriminatorValue(value = "S")
@PrimaryKeyJoinColumn(name = "RECIPE_ID")
public class ShopRecipe extends Recipe{
	private boolean isMenu;

	public ShopRecipe() {
		super();
		this.setIsMenu(false);
	}

	public boolean getIsMenu() {
		return isMenu;
	}

	public void setIsMenu(boolean isMenu) {
		this.isMenu = isMenu;
	}
}
