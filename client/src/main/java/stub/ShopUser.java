
package stub;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for shopUser complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="shopUser">
 *   &lt;complexContent>
 *     &lt;extension base="{http://webservice/}user">
 *       &lt;sequence>
 *         &lt;element name="managedShop" type="{http://webservice/}shop" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "shopUser", propOrder = {
    "managedShop"
})
public class ShopUser
    extends User
{

    protected Shop managedShop;

    /**
     * Gets the value of the managedShop property.
     * 
     * @return
     *     possible object is
     *     {@link Shop }
     *     
     */
    public Shop getManagedShop() {
        return managedShop;
    }

    /**
     * Sets the value of the managedShop property.
     * 
     * @param value
     *     allowed object is
     *     {@link Shop }
     *     
     */
    public void setManagedShop(Shop value) {
        this.managedShop = value;
    }

}
