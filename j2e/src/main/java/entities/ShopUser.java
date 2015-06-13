package entities;

import javax.persistence.*;

/**
 * Created by Tom Veniat on 24/03/15.
 */

@Entity
@Table(name = "SHOP_USER")
public class ShopUser extends User {

    private Shop managedShop;

    public ShopUser() {
        super();
        managedShop = null;
    }

    public ShopUser(String email, String firstname, String lastname) {
        super(email, firstname, lastname);
        managedShop = null;
    }


    @OneToOne(cascade={CascadeType.MERGE,CascadeType.REMOVE, CascadeType.REFRESH}, orphanRemoval=true)
    public Shop getManagedShop() {
        return this.managedShop;
    }

    public void setManagedShop(Shop managedShop) {
        this.managedShop = managedShop;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShopUser)) return false;
        if (!super.equals(o)) return false;

        ShopUser shopUser = (ShopUser) o;

        if (getManagedShop() != null ? !getManagedShop().equals(shopUser.getManagedShop()) : shopUser.getManagedShop() != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getManagedShop() != null ? getManagedShop().hashCode() : 0);
        return result;
    }
}
