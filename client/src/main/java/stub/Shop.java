
package stub;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for shop complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="shop">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="address" type="{http://webservice/}address" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="nbMaxCookie" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nbMaxCustomer" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="taxe" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "shop", propOrder = {
    "address",
    "id",
    "nbMaxCookie",
    "nbMaxCustomer",
    "taxe"
})
public class Shop {

    protected Address address;
    protected Long id;
    protected int nbMaxCookie;
    protected int nbMaxCustomer;
    protected double taxe;

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setAddress(Address value) {
        this.address = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setId(Long value) {
        this.id = value;
    }

    /**
     * Gets the value of the nbMaxCookie property.
     * 
     */
    public int getNbMaxCookie() {
        return nbMaxCookie;
    }

    /**
     * Sets the value of the nbMaxCookie property.
     * 
     */
    public void setNbMaxCookie(int value) {
        this.nbMaxCookie = value;
    }

    /**
     * Gets the value of the nbMaxCustomer property.
     * 
     */
    public int getNbMaxCustomer() {
        return nbMaxCustomer;
    }

    /**
     * Sets the value of the nbMaxCustomer property.
     * 
     */
    public void setNbMaxCustomer(int value) {
        this.nbMaxCustomer = value;
    }

    /**
     * Gets the value of the taxe property.
     * 
     */
    public double getTaxe() {
        return taxe;
    }

    /**
     * Sets the value of the taxe property.
     * 
     */
    public void setTaxe(double value) {
        this.taxe = value;
    }

}
