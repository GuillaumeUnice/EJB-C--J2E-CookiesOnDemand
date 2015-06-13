
package stub;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for personalRecipe complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="personalRecipe">
 *   &lt;complexContent>
 *     &lt;extension base="{http://webservice/}recipe">
 *       &lt;sequence>
 *         &lt;element name="cooking" type="{http://webservice/}cooking" minOccurs="0"/>
 *         &lt;element name="dough" type="{http://webservice/}dough" minOccurs="0"/>
 *         &lt;element name="flavour" type="{http://webservice/}flavour" minOccurs="0"/>
 *         &lt;element name="mix" type="{http://webservice/}mix" minOccurs="0"/>
 *         &lt;element name="topping" type="{http://webservice/}topping" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="user" type="{http://webservice/}customerUser" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "personalRecipe", propOrder = {
    "cooking",
    "dough",
    "flavour",
    "mix",
    "topping",
    "user"
})
public class PersonalRecipe
    extends Recipe
{

    protected Cooking cooking;
    protected Dough dough;
    protected Flavour flavour;
    protected Mix mix;
    @XmlElement(nillable = true)
    protected List<Topping> topping;
    protected CustomerUser user;

    /**
     * Gets the value of the cooking property.
     * 
     * @return
     *     possible object is
     *     {@link Cooking }
     *     
     */
    public Cooking getCooking() {
        return cooking;
    }

    /**
     * Sets the value of the cooking property.
     * 
     * @param value
     *     allowed object is
     *     {@link Cooking }
     *     
     */
    public void setCooking(Cooking value) {
        this.cooking = value;
    }

    /**
     * Gets the value of the dough property.
     * 
     * @return
     *     possible object is
     *     {@link Dough }
     *     
     */
    public Dough getDough() {
        return dough;
    }

    /**
     * Sets the value of the dough property.
     * 
     * @param value
     *     allowed object is
     *     {@link Dough }
     *     
     */
    public void setDough(Dough value) {
        this.dough = value;
    }

    /**
     * Gets the value of the flavour property.
     * 
     * @return
     *     possible object is
     *     {@link Flavour }
     *     
     */
    public Flavour getFlavour() {
        return flavour;
    }

    /**
     * Sets the value of the flavour property.
     * 
     * @param value
     *     allowed object is
     *     {@link Flavour }
     *     
     */
    public void setFlavour(Flavour value) {
        this.flavour = value;
    }

    /**
     * Gets the value of the mix property.
     * 
     * @return
     *     possible object is
     *     {@link Mix }
     *     
     */
    public Mix getMix() {
        return mix;
    }

    /**
     * Sets the value of the mix property.
     * 
     * @param value
     *     allowed object is
     *     {@link Mix }
     *     
     */
    public void setMix(Mix value) {
        this.mix = value;
    }

    /**
     * Gets the value of the topping property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the topping property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTopping().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Topping }
     * 
     * 
     */
    public List<Topping> getTopping() {
        if (topping == null) {
            topping = new ArrayList<Topping>();
        }
        return this.topping;
    }

    /**
     * Gets the value of the user property.
     * 
     * @return
     *     possible object is
     *     {@link CustomerUser }
     *     
     */
    public CustomerUser getUser() {
        return user;
    }

    /**
     * Sets the value of the user property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerUser }
     *     
     */
    public void setUser(CustomerUser value) {
        this.user = value;
    }

}
