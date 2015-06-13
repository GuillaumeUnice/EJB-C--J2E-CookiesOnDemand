
package stub;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for createShopRecipe complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="createShopRecipe">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ShopRecipe" type="{http://webservice/}shopRecipe" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createShopRecipe", propOrder = {
    "shopRecipe"
})
public class CreateShopRecipe {

    @XmlElement(name = "ShopRecipe")
    protected ShopRecipe shopRecipe;

    /**
     * Gets the value of the shopRecipe property.
     * 
     * @return
     *     possible object is
     *     {@link ShopRecipe }
     *     
     */
    public ShopRecipe getShopRecipe() {
        return shopRecipe;
    }

    /**
     * Sets the value of the shopRecipe property.
     * 
     * @param value
     *     allowed object is
     *     {@link ShopRecipe }
     *     
     */
    public void setShopRecipe(ShopRecipe value) {
        this.shopRecipe = value;
    }

}
