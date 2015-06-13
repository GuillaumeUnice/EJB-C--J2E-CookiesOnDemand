
package stub;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getAllRecipesByUserResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getAllRecipesByUserResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OneUserRecipes" type="{http://webservice/}personalRecipe" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAllRecipesByUserResponse", propOrder = {
    "oneUserRecipes"
})
public class GetAllRecipesByUserResponse {

    @XmlElement(name = "OneUserRecipes")
    protected List<PersonalRecipe> oneUserRecipes;

    /**
     * Gets the value of the oneUserRecipes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the oneUserRecipes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOneUserRecipes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PersonalRecipe }
     * 
     * 
     */
    public List<PersonalRecipe> getOneUserRecipes() {
        if (oneUserRecipes == null) {
            oneUserRecipes = new ArrayList<PersonalRecipe>();
        }
        return this.oneUserRecipes;
    }

}
