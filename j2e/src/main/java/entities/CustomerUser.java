package entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CUSTOMER_USER")
public class CustomerUser extends User{

    private List<PersonalRecipe> listRecipe;
    private boolean loyaltyProgram;
    private double giftCardCredit;
    private Shop favouriteShop;
    private Long creditCard;

    public CustomerUser() {
        super();
        loyaltyProgram = false;
        giftCardCredit = 0;
        favouriteShop = null;
    }

    public CustomerUser(String email, String firstname, String lastname) {
        super(email, firstname, lastname);
        loyaltyProgram = false;
        giftCardCredit = 0;
        favouriteShop = null;
    }

    @OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
	public List<PersonalRecipe> getListRecipe() {
		return listRecipe;
	}

	public void setListRecipe(List<PersonalRecipe> listRecipe) {
		this.listRecipe = listRecipe;
	}

    public void setFavouriteShop(Shop preferateShop) {
        this.favouriteShop = preferateShop;
    }

    public boolean isLoyaltyProgram() {
        return loyaltyProgram;
    }

    public void setLoyaltyProgram(boolean loyaltyProgram) {
        this.loyaltyProgram = loyaltyProgram;
    }

    public double getGiftCardCredit() {
        return giftCardCredit;
    }

    public void setGiftCardCredit(double giftCardCredit) {
        this.giftCardCredit = giftCardCredit;
    }

    @ManyToOne(cascade = {CascadeType.MERGE})
    public Shop getFavouriteShop() {
        return favouriteShop;
    }

    public Long getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(Long cardNumber) {
        this.creditCard = cardNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerUser)) return false;
        if (!super.equals(o)) return false;

        CustomerUser that = (CustomerUser) o;

        if (Double.compare(that.getGiftCardCredit(), getGiftCardCredit()) != 0) return false;
        if (isLoyaltyProgram() != that.isLoyaltyProgram()) return false;
        if (getFavouriteShop() != null ? !getFavouriteShop().equals(that.getFavouriteShop()) : that.getFavouriteShop() != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        result = 31 * result + (isLoyaltyProgram() ? 1 : 0);
        temp = Double.doubleToLongBits(getGiftCardCredit());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (getFavouriteShop() != null ? getFavouriteShop().hashCode() : 0);
        return result;
    }

}
