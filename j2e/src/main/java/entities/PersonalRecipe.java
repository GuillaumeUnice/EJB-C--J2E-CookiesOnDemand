package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "PERSONAL_RECIPE")
@DiscriminatorValue(value = "P")
@PrimaryKeyJoinColumn(name = "RECIPE_ID")
public class PersonalRecipe extends Recipe {

	private CustomerUser user;

	/*One dought*/
	private Dough dough;

	/*Zero or one flavour*/
	private Flavour flavour;

	/*One mix*/
	private Mix mix;

	/*One cooking*/
	private Cooking cooking;

	/*0 to 3 toppings*/
	private List<Topping> topping;


	@ManyToOne(fetch = FetchType.EAGER)
	public CustomerUser getUser() {
		return user;
	}

	public void setUser(CustomerUser user) {
		this.user = user;
	}

	@Enumerated(EnumType.STRING)
	public Dough getDough() {
		return dough;
	}

	public void setDough(Dough dough) {
		this.dough = dough;
	}

	@Enumerated(EnumType.STRING)
	public Flavour getFlavour() {
		return flavour;
	}

	public void setFlavour(Flavour flavour) {
		this.flavour = flavour;
	}

	@Enumerated(EnumType.STRING)
	public Mix getMix() {
		return mix;
	}

	public void setMix(Mix mix) {
		this.mix = mix;
	}

	@Enumerated(EnumType.STRING)
	public Cooking getCooking() {
		return cooking;
	}

	public void setCooking(Cooking cooking) {
		this.cooking = cooking;
	}

	@ElementCollection(targetClass = Topping.class, fetch = FetchType.EAGER)
	@Enumerated(EnumType.STRING)
	public List<Topping> getTopping() {
		return topping;
	}

	public void setTopping(List<Topping> topping) {
		this.topping = topping;
	}

	public PersonalRecipe() {
		super();
		this.setTopping(new ArrayList<Topping>());
	}

	
	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof PersonalRecipe)) return false;
		if (!super.equals(o)) return false;

		PersonalRecipe that = (PersonalRecipe) o;

		if (getUser() != null ? !getUser().equals(that.getUser()) : that.getUser() != null) return false;
		if (getDough() != that.getDough()) return false;
		if (getFlavour() != that.getFlavour()) return false;
		if (getMix() != that.getMix()) return false;
		if (getCooking() != that.getCooking()) return false;
		return !(getTopping() != null ? !getTopping().equals(that.getTopping()) : that.getTopping() != null);

	}
}
