
package stub;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getAllShopUsersResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getAllShopUsersResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ShopUsers" type="{http://webservice/}shopUser" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAllShopUsersResponse", propOrder = {
    "shopUsers"
})
public class GetAllShopUsersResponse {

    @XmlElement(name = "ShopUsers")
    protected List<ShopUser> shopUsers;

    /**
     * Gets the value of the shopUsers property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the shopUsers property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getShopUsers().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ShopUser }
     * 
     * 
     */
    public List<ShopUser> getShopUsers() {
        if (shopUsers == null) {
            shopUsers = new ArrayList<ShopUser>();
        }
        return this.shopUsers;
    }

}
