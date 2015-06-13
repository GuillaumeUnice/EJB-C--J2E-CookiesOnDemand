
package stub;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getCustomerUserByIdResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getCustomerUserByIdResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CustomerUser" type="{http://webservice/}customerUser" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCustomerUserByIdResponse", propOrder = {
    "customerUser"
})
public class GetCustomerUserByIdResponse {

    @XmlElement(name = "CustomerUser")
    protected CustomerUser customerUser;

    /**
     * Gets the value of the customerUser property.
     * 
     * @return
     *     possible object is
     *     {@link CustomerUser }
     *     
     */
    public CustomerUser getCustomerUser() {
        return customerUser;
    }

    /**
     * Sets the value of the customerUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerUser }
     *     
     */
    public void setCustomerUser(CustomerUser value) {
        this.customerUser = value;
    }

}
