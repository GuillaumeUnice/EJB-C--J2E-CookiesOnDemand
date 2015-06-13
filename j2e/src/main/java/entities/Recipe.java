package entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "RECIPE")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "RECIPE_TYPE", discriminatorType = DiscriminatorType.STRING, length = 1)
public class Recipe {

	private Long id;
	private String description;
	private String name;
	private double dutyFreePrice;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	@Column(length = 255)
	public void setDescription(String description) {
		this.description = description;
	}

	@Column(length = 60)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getDutyFreePrice() {
		return dutyFreePrice;
	}

	public void setDutyFreePrice(double preTaxePrice) {
		this.dutyFreePrice = preTaxePrice;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Recipe)) return false;

        Recipe recipe = (Recipe) o;

        if (Double.compare(recipe.getDutyFreePrice(), getDutyFreePrice()) != 0) return false;
        if (getDescription() != null ? !getDescription().equals(recipe.getDescription()) : recipe.getDescription() != null) return false;
        if (getId() != null ? !getId().equals(recipe.getId()) : recipe.getId() != null) return false;
        if (getName() != null ? !getName().equals(recipe.getName()) : recipe.getName() != null) return false;

        return true;
    }


}
