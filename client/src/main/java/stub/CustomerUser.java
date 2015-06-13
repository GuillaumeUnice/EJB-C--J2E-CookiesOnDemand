
package stub;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for customerUser complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="customerUser">
 *   &lt;complexContent>
 *     &lt;extension base="{http://webservice/}user">
 *       &lt;sequence>
 *         &lt;element name="creditCard" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="favouriteShop" type="{http://webservice/}shop" minOccurs="0"/>
 *         &lt;element name="giftCardCredit" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="listRecipe" type="{http://webservice/}personalRecipe" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="loyaltyProgram" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerUser", propOrder = {
    "creditCard",
    "favouriteShop",
    "giftCardCredit",
    "listRecipe",
    "loyaltyProgram"
})
public class CustomerUser
    extends User
{

    protected Long creditCard;
    protected Shop favouriteShop;
    protected double giftCardCredit;
    @XmlElement(nillable = true)
    protected List<PersonalRecipe> listRecipe;
    protected boolean loyaltyProgram;

    /**
     * Gets the value of the creditCard property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCreditCard() {
        return creditCard;
    }

    /**
     * Sets the value of the creditCard property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCreditCard(Long value) {
        this.creditCard = value;
    }

    /**
     * Gets the value of the favouriteShop property.
     * 
     * @return
     *     possible object is
     *     {@link Shop }
     *     
     */
    public Shop getFavouriteShop() {
        return favouriteShop;
    }

    /**
     * Sets the value of the favouriteShop property.
     * 
     * @param value
     *     allowed object is
     *     {@link Shop }
     *     
     */
    public void setFavouriteShop(Shop value) {
        this.favouriteShop = value;
    }

    /**
     * Gets the value of the giftCardCredit property.
     * 
     */
    public double getGiftCardCredit() {
        return giftCardCredit;
    }

    /**
     * Sets the value of the giftCardCredit property.
     * 
     */
    public void setGiftCardCredit(double value) {
        this.giftCardCredit = value;
    }

    /**
     * Gets the value of the listRecipe property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listRecipe property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListRecipe().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PersonalRecipe }
     * 
     * 
     */
    public List<PersonalRecipe> getListRecipe() {
        if (listRecipe == null) {
            listRecipe = new ArrayList<PersonalRecipe>();
        }
        return this.listRecipe;
    }

    /**
     * Gets the value of the loyaltyProgram property.
     * 
     */
    public boolean isLoyaltyProgram() {
        return loyaltyProgram;
    }

    /**
     * Sets the value of the loyaltyProgram property.
     * 
     */
    public void setLoyaltyProgram(boolean value) {
        this.loyaltyProgram = value;
    }

}
