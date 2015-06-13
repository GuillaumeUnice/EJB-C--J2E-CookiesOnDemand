
package stub;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for shopRecipe complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="shopRecipe">
 *   &lt;complexContent>
 *     &lt;extension base="{http://webservice/}recipe">
 *       &lt;sequence>
 *         &lt;element name="isMenu" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "shopRecipe", propOrder = {
    "isMenu"
})
public class ShopRecipe
    extends Recipe
{

    protected boolean isMenu;

    /**
     * Gets the value of the isMenu property.
     * 
     */
    public boolean isIsMenu() {
        return isMenu;
    }

    /**
     * Sets the value of the isMenu property.
     * 
     */
    public void setIsMenu(boolean value) {
        this.isMenu = value;
    }

}
