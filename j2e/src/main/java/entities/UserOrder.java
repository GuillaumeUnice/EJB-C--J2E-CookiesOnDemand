package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "USERS_ORDER")
@Access(AccessType.PROPERTY)
public class UserOrder implements Serializable{

	private Long id;
	private CustomerUser user;
	private Shop shop;
	private List<Product> products;
	private Date date;


	@Temporal(TemporalType.TIME)
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER, orphanRemoval=true)
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@ManyToOne(cascade = CascadeType.MERGE)
	public CustomerUser getUser() {
		return user;
	}
	public void setUser(CustomerUser user) {
		this.user = user;
	}


	@ManyToOne
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public UserOrder() {
		this.products = new ArrayList<Product>();
	}

	@Override
	public String toString(){
		String str ="Order n°"+getId()+", made by "+getUser()+" the "+getDate()+" with " + getProducts().size() + " recipe(s) :" ;
		for (Product p : getProducts())
			if (p.getRecipe()!=null)
				str += "\n\t -" + p.getRecipe().getName() + " en " + p.getQuantity() + " exemplaires.";
		return str;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof UserOrder))
			return false;

		UserOrder userOrder = (UserOrder) o;

		if (getId() != null ? !getId().equals(userOrder.getId()) : userOrder
				.getId() != null)
			return false;
		if (getShop() != null ? !getShop().equals(userOrder.getShop())
				: userOrder.getShop() != null)
			return false;
		if (getUser() != null ? !getUser().equals(userOrder.getUser())
				: userOrder.getUser() != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

}
