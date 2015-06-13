
package stub;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for createPersonalRecipeResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="createPersonalRecipeResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PersonalRecipeCreated" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createPersonalRecipeResponse", propOrder = {
    "personalRecipeCreated"
})
public class CreatePersonalRecipeResponse {

    @XmlElement(name = "PersonalRecipeCreated")
    protected Long personalRecipeCreated;

    /**
     * Gets the value of the personalRecipeCreated property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPersonalRecipeCreated() {
        return personalRecipeCreated;
    }

    /**
     * Sets the value of the personalRecipeCreated property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPersonalRecipeCreated(Long value) {
        this.personalRecipeCreated = value;
    }

}
