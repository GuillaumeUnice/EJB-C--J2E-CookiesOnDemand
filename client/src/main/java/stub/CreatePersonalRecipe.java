
package stub;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for createPersonalRecipe complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="createPersonalRecipe">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PersonalRecipe" type="{http://webservice/}personalRecipe" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createPersonalRecipe", propOrder = {
    "personalRecipe"
})
public class CreatePersonalRecipe {

    @XmlElement(name = "PersonalRecipe")
    protected PersonalRecipe personalRecipe;

    /**
     * Gets the value of the personalRecipe property.
     * 
     * @return
     *     possible object is
     *     {@link PersonalRecipe }
     *     
     */
    public PersonalRecipe getPersonalRecipe() {
        return personalRecipe;
    }

    /**
     * Sets the value of the personalRecipe property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonalRecipe }
     *     
     */
    public void setPersonalRecipe(PersonalRecipe value) {
        this.personalRecipe = value;
    }

}
