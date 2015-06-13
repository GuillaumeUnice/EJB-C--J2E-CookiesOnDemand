package entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Maxime Dito on 10/03/2015.
 */
@Entity
@Table(name = "SHOP")
public class Shop implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    //private LocalGregorianCalendar openDate;
    //private LocalGregorianCalendar closeDate;
    private double taxe;
    private int nbMaxCustomer;
    private int nbMaxCookie;
    private Address address;
    private List<UserOrder> orders;

    public Shop() {
        taxe = 0;
        nbMaxCookie = 0;
        nbMaxCustomer = 0;
        address = new Address();
    }

    public Shop(double taxe, int nbMaxCookie, int nbMaxCustomer, Address adress) {
        this.taxe = taxe;
        this.nbMaxCookie = nbMaxCookie;
        this.nbMaxCustomer = nbMaxCustomer;
        this.address = adress;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getTaxe() {
        return taxe;
    }

    public void setTaxe(double taxe) {
        this.taxe = taxe;
    }

    public int getNbMaxCustomer() {
        return nbMaxCustomer;
    }

    public void setNbMaxCustomer(int nbMaxCustomer) {
        this.nbMaxCustomer = nbMaxCustomer;
    }

    public int getNbMaxCookie() {
        return nbMaxCookie;
    }

    public void setNbMaxCookie(int nbMaxCookie) {
        this.nbMaxCookie = nbMaxCookie;
    }

    @Embedded
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @OneToMany(mappedBy = "shop", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @XmlTransient
    public List<UserOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<UserOrder> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Shop)) return false;

        Shop shop = (Shop) o;

        if (getNbMaxCookie() != shop.getNbMaxCookie()) return false;
        if (getNbMaxCustomer() != shop.getNbMaxCustomer()) return false;
        if (Double.compare(shop.getTaxe(), getTaxe()) != 0) return false;
        if (getAddress() != null ? !getAddress().equals(shop.getAddress()) : shop.getAddress() != null) return false;
        if (getId() != null ? !getId().equals(shop.getId()) : shop.getId() != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getId() != null ? getId().hashCode() : 0;
        temp = Double.doubleToLongBits(getTaxe());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + getNbMaxCustomer();
        result = 31 * result + getNbMaxCookie();
        result = 31 * result + (getAddress() != null ? getAddress().hashCode() : 0);
//        result = 31 * result + (getOrders() != null ? getOrders().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Magasin n°"+getId()+" se trouvant à "+getAddress()+".";
    }
}
