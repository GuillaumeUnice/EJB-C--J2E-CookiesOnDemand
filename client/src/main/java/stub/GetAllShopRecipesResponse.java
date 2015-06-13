
package stub;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getAllShopRecipesResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getAllShopRecipesResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AllShopRecipes" type="{http://webservice/}shopRecipe" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAllShopRecipesResponse", propOrder = {
    "allShopRecipes"
})
public class GetAllShopRecipesResponse {

    @XmlElement(name = "AllShopRecipes")
    protected List<ShopRecipe> allShopRecipes;

    /**
     * Gets the value of the allShopRecipes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the allShopRecipes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAllShopRecipes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ShopRecipe }
     * 
     * 
     */
    public List<ShopRecipe> getAllShopRecipes() {
        if (allShopRecipes == null) {
            allShopRecipes = new ArrayList<ShopRecipe>();
        }
        return this.allShopRecipes;
    }

}
