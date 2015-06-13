
package stub;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the stub package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetAllOrdersbyShop_QNAME = new QName("http://webservice/", "getAllOrdersbyShop");
    private final static QName _GetShopByShopUserResponse_QNAME = new QName("http://webservice/", "getShopByShopUserResponse");
    private final static QName _ChangeShopUser_QNAME = new QName("http://webservice/", "changeShopUser");
    private final static QName _ChangeShopUserResponse_QNAME = new QName("http://webservice/", "changeShopUserResponse");
    private final static QName _GetAllOrdersbyShopResponse_QNAME = new QName("http://webservice/", "getAllOrdersbyShopResponse");
    private final static QName _GetShopByShopUser_QNAME = new QName("http://webservice/", "getShopByShopUser");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: stub
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ChangeShopUser }
     * 
     */
    public ChangeShopUser createChangeShopUser() {
        return new ChangeShopUser();
    }

    /**
     * Create an instance of {@link GetShopByShopUserResponse }
     * 
     */
    public GetShopByShopUserResponse createGetShopByShopUserResponse() {
        return new GetShopByShopUserResponse();
    }

    /**
     * Create an instance of {@link GetAllOrdersbyShop }
     * 
     */
    public GetAllOrdersbyShop createGetAllOrdersbyShop() {
        return new GetAllOrdersbyShop();
    }

    /**
     * Create an instance of {@link GetAllOrdersbyShopResponse }
     * 
     */
    public GetAllOrdersbyShopResponse createGetAllOrdersbyShopResponse() {
        return new GetAllOrdersbyShopResponse();
    }

    /**
     * Create an instance of {@link GetShopByShopUser }
     * 
     */
    public GetShopByShopUser createGetShopByShopUser() {
        return new GetShopByShopUser();
    }

    /**
     * Create an instance of {@link ChangeShopUserResponse }
     * 
     */
    public ChangeShopUserResponse createChangeShopUserResponse() {
        return new ChangeShopUserResponse();
    }

    /**
     * Create an instance of {@link Shop }
     * 
     */
    public Shop createShop() {
        return new Shop();
    }

    /**
     * Create an instance of {@link PersonalRecipe }
     * 
     */
    public PersonalRecipe createPersonalRecipe() {
        return new PersonalRecipe();
    }

    /**
     * Create an instance of {@link Recipe }
     * 
     */
    public Recipe createRecipe() {
        return new Recipe();
    }

    /**
     * Create an instance of {@link Product }
     * 
     */
    public Product createProduct() {
        return new Product();
    }

    /**
     * Create an instance of {@link UserOrder }
     * 
     */
    public UserOrder createUserOrder() {
        return new UserOrder();
    }

    /**
     * Create an instance of {@link Address }
     * 
     */
    public Address createAddress() {
        return new Address();
    }

    /**
     * Create an instance of {@link CustomerUser }
     * 
     */
    public CustomerUser createCustomerUser() {
        return new CustomerUser();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllOrdersbyShop }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "getAllOrdersbyShop")
    public JAXBElement<GetAllOrdersbyShop> createGetAllOrdersbyShop(GetAllOrdersbyShop value) {
        return new JAXBElement<GetAllOrdersbyShop>(_GetAllOrdersbyShop_QNAME, GetAllOrdersbyShop.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetShopByShopUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "getShopByShopUserResponse")
    public JAXBElement<GetShopByShopUserResponse> createGetShopByShopUserResponse(GetShopByShopUserResponse value) {
        return new JAXBElement<GetShopByShopUserResponse>(_GetShopByShopUserResponse_QNAME, GetShopByShopUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChangeShopUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "changeShopUser")
    public JAXBElement<ChangeShopUser> createChangeShopUser(ChangeShopUser value) {
        return new JAXBElement<ChangeShopUser>(_ChangeShopUser_QNAME, ChangeShopUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChangeShopUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "changeShopUserResponse")
    public JAXBElement<ChangeShopUserResponse> createChangeShopUserResponse(ChangeShopUserResponse value) {
        return new JAXBElement<ChangeShopUserResponse>(_ChangeShopUserResponse_QNAME, ChangeShopUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllOrdersbyShopResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "getAllOrdersbyShopResponse")
    public JAXBElement<GetAllOrdersbyShopResponse> createGetAllOrdersbyShopResponse(GetAllOrdersbyShopResponse value) {
        return new JAXBElement<GetAllOrdersbyShopResponse>(_GetAllOrdersbyShopResponse_QNAME, GetAllOrdersbyShopResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetShopByShopUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "getShopByShopUser")
    public JAXBElement<GetShopByShopUser> createGetShopByShopUser(GetShopByShopUser value) {
        return new JAXBElement<GetShopByShopUser>(_GetShopByShopUser_QNAME, GetShopByShopUser.class, null, value);
    }

}
