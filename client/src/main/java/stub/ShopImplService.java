
package stub;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "ShopImplService", targetNamespace = "http://www.polytech.unice.fr/si/4a/appserv/demos", wsdlLocation = "http://localhost:8080/COD_V0/webservices/ShopService?wsdl")
public class ShopImplService
    extends Service
{

    private final static URL SHOPIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException SHOPIMPLSERVICE_EXCEPTION;
    private final static QName SHOPIMPLSERVICE_QNAME = new QName("http://www.polytech.unice.fr/si/4a/appserv/demos", "ShopImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/COD_V0/webservices/ShopService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SHOPIMPLSERVICE_WSDL_LOCATION = url;
        SHOPIMPLSERVICE_EXCEPTION = e;
    }

    public ShopImplService() {
        super(__getWsdlLocation(), SHOPIMPLSERVICE_QNAME);
    }

    public ShopImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), SHOPIMPLSERVICE_QNAME, features);
    }

    public ShopImplService(URL wsdlLocation) {
        super(wsdlLocation, SHOPIMPLSERVICE_QNAME);
    }

    public ShopImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SHOPIMPLSERVICE_QNAME, features);
    }

    public ShopImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ShopImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ShopWs
     */
    @WebEndpoint(name = "ShopImplPort")
    public ShopWs getShopImplPort() {
        return super.getPort(new QName("http://www.polytech.unice.fr/si/4a/appserv/demos", "ShopImplPort"), ShopWs.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ShopWs
     */
    @WebEndpoint(name = "ShopImplPort")
    public ShopWs getShopImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.polytech.unice.fr/si/4a/appserv/demos", "ShopImplPort"), ShopWs.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SHOPIMPLSERVICE_EXCEPTION!= null) {
            throw SHOPIMPLSERVICE_EXCEPTION;
        }
        return SHOPIMPLSERVICE_WSDL_LOCATION;
    }

}
