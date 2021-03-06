
package stub;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ShopWs", targetNamespace = "http://webservice/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ShopWs {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<stub.UserOrder>
     */
    @WebMethod
    @WebResult(name = "ShopOrders", targetNamespace = "")
    @RequestWrapper(localName = "getAllOrdersbyShop", targetNamespace = "http://webservice/", className = "stub.GetAllOrdersbyShop")
    @ResponseWrapper(localName = "getAllOrdersbyShopResponse", targetNamespace = "http://webservice/", className = "stub.GetAllOrdersbyShopResponse")
    public List<UserOrder> getAllOrdersbyShop(
        @WebParam(name = "arg0", targetNamespace = "")
        Long arg0);

    /**
     * 
     * @param arg1
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "changeShopUser", targetNamespace = "http://webservice/", className = "stub.ChangeShopUser")
    @ResponseWrapper(localName = "changeShopUserResponse", targetNamespace = "http://webservice/", className = "stub.ChangeShopUserResponse")
    public void changeShopUser(
        @WebParam(name = "arg0", targetNamespace = "")
        Long arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1);

    /**
     * 
     * @param user
     * @return
     *     returns stub.Shop
     */
    @WebMethod
    @WebResult(name = "Shop", targetNamespace = "")
    @RequestWrapper(localName = "getShopByShopUser", targetNamespace = "http://webservice/", className = "stub.GetShopByShopUser")
    @ResponseWrapper(localName = "getShopByShopUserResponse", targetNamespace = "http://webservice/", className = "stub.GetShopByShopUserResponse")
    public Shop getShopByShopUser(
        @WebParam(name = "User", targetNamespace = "")
        User user);

}
