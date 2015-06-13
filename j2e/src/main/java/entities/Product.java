package entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PRODUCT")
public class Product implements Serializable {

	private Long id;
	private int quantity;
	private Recipe recipe;
	private UserOrder order;




	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	@ManyToOne
	public UserOrder getOrder() {
		return order;
	}

	public void setOrder(UserOrder order) {
		this.order = order;
	}


	@ManyToOne(fetch  = FetchType.EAGER, cascade = {CascadeType.MERGE})
	@JoinColumn(name = "RECIPE_ID", referencedColumnName = "ID")
	public Recipe getRecipe() {
		return recipe;
	}
	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}




	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Product)) return false;

		Product product = (Product) o;

		if (getQuantity() != product.getQuantity()) return false;
		if (getId() != null ? !getId().equals(product.getId()) : product.getId() != null) return false;
		return !(getOrder() != null ? !getOrder().equals(product.getOrder()) : product.getOrder() != null);

	}

	@Override
	public int hashCode() {
		int result = getId() != null ? getId().hashCode() : 0;
		result = 31 * result + getQuantity();
		result = 31 * result + (getOrder() != null ? getOrder().hashCode() : 0);
		return result;
	}
}
