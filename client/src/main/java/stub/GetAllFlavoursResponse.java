
package stub;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getAllFlavoursResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getAllFlavoursResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Flavours" type="{http://webservice/}flavour" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAllFlavoursResponse", propOrder = {
    "flavours"
})
public class GetAllFlavoursResponse {

    @XmlElement(name = "Flavours")
    protected List<Flavour> flavours;

    /**
     * Gets the value of the flavours property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the flavours property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFlavours().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Flavour }
     * 
     * 
     */
    public List<Flavour> getFlavours() {
        if (flavours == null) {
            flavours = new ArrayList<Flavour>();
        }
        return this.flavours;
    }

}
