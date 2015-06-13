
package stub;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getShopUserByIdResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getShopUserByIdResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ShopUser" type="{http://webservice/}shopUser" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getShopUserByIdResponse", propOrder = {
    "shopUser"
})
public class GetShopUserByIdResponse {

    @XmlElement(name = "ShopUser")
    protected ShopUser shopUser;

    /**
     * Gets the value of the shopUser property.
     * 
     * @return
     *     possible object is
     *     {@link ShopUser }
     *     
     */
    public ShopUser getShopUser() {
        return shopUser;
    }

    /**
     * Sets the value of the shopUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link ShopUser }
     *     
     */
    public void setShopUser(ShopUser value) {
        this.shopUser = value;
    }

}
