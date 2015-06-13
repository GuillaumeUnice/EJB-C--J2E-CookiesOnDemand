
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
@WebServiceClient(name = "UsersImplService", targetNamespace = "http://www.polytech.unice.fr/si/4a/appserv/demos", wsdlLocation = "http://localhost:8080/COD_V0/webservices/UsersService?wsdl")
public class UsersImplService
    extends Service
{

    private final static URL USERSIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException USERSIMPLSERVICE_EXCEPTION;
    private final static QName USERSIMPLSERVICE_QNAME = new QName("http://www.polytech.unice.fr/si/4a/appserv/demos", "UsersImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/COD_V0/webservices/UsersService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        USERSIMPLSERVICE_WSDL_LOCATION = url;
        USERSIMPLSERVICE_EXCEPTION = e;
    }

    public UsersImplService() {
        super(__getWsdlLocation(), USERSIMPLSERVICE_QNAME);
    }

    public UsersImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), USERSIMPLSERVICE_QNAME, features);
    }

    public UsersImplService(URL wsdlLocation) {
        super(wsdlLocation, USERSIMPLSERVICE_QNAME);
    }

    public UsersImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, USERSIMPLSERVICE_QNAME, features);
    }

    public UsersImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public UsersImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns UsersWs
     */
    @WebEndpoint(name = "UsersImplPort")
    public UsersWs getUsersImplPort() {
        return super.getPort(new QName("http://www.polytech.unice.fr/si/4a/appserv/demos", "UsersImplPort"), UsersWs.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns UsersWs
     */
    @WebEndpoint(name = "UsersImplPort")
    public UsersWs getUsersImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.polytech.unice.fr/si/4a/appserv/demos", "UsersImplPort"), UsersWs.class, features);
    }

    private static URL __getWsdlLocation() {
        if (USERSIMPLSERVICE_EXCEPTION!= null) {
            throw USERSIMPLSERVICE_EXCEPTION;
        }
        return USERSIMPLSERVICE_WSDL_LOCATION;
    }

}
