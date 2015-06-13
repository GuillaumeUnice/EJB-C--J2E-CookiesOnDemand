
package stub;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for createShop complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="createShop">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Location" type="{http://webservice/}address" minOccurs="0"/>
 *         &lt;element name="MaxClientsNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="MaxCookiesNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Taxe" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createShop", propOrder = {
    "location",
    "maxClientsNumber",
    "maxCookiesNumber",
    "taxe",
    "id",
    "password"
})
public class CreateShop {

    @XmlElement(name = "Location")
    protected Address location;
    @XmlElement(name = "MaxClientsNumber")
    protected int maxClientsNumber;
    @XmlElement(name = "MaxCookiesNumber")
    protected int maxCookiesNumber;
    @XmlElement(name = "Taxe")
    protected double taxe;
    protected String id;
    protected String password;

    /**
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setLocation(Address value) {
        this.location = value;
    }

    /**
     * Gets the value of the maxClientsNumber property.
     * 
     */
    public int getMaxClientsNumber() {
        return maxClientsNumber;
    }

    /**
     * Sets the value of the maxClientsNumber property.
     * 
     */
    public void setMaxClientsNumber(int value) {
        this.maxClientsNumber = value;
    }

    /**
     * Gets the value of the maxCookiesNumber property.
     * 
     */
    public int getMaxCookiesNumber() {
        return maxCookiesNumber;
    }

    /**
     * Sets the value of the maxCookiesNumber property.
     * 
     */
    public void setMaxCookiesNumber(int value) {
        this.maxCookiesNumber = value;
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

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the password property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

}
