
package stub;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getAllOrdersbyShopResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getAllOrdersbyShopResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ShopOrders" type="{http://webservice/}userOrder" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAllOrdersbyShopResponse", propOrder = {
    "shopOrders"
})
public class GetAllOrdersbyShopResponse {

    @XmlElement(name = "ShopOrders")
    protected List<UserOrder> shopOrders;

    /**
     * Gets the value of the shopOrders property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the shopOrders property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getShopOrders().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UserOrder }
     * 
     * 
     */
    public List<UserOrder> getShopOrders() {
        if (shopOrders == null) {
            shopOrders = new ArrayList<UserOrder>();
        }
        return this.shopOrders;
    }

}
