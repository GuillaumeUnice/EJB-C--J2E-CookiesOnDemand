package domain.implem;

import UserAndPayment.IUserAndPaymentService;
import UserAndPayment.UserAndPaymentService;
import domain.Authentifier;
import entities.Connection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.ws.BindingProvider;
import java.net.URL;
import java.util.Date;
import java.util.List;

/**
 * Created by Tom Veniat on 16/05/15.
 */

@Stateless
public class AuthentifierBean implements Authentifier{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public boolean connect(String email, String password) {
        Connection connection;
        if (isConnected(email)){
            connection = getLastConnection(email);
            connection.setTimeStamp(new Date().getTime());
            entityManager.merge(connection);
            System.out.println("### - STILL CONNECTED");
            return true;
        } else {
            String address = "http://localhost:50828/UserAndPaymentService.svc";
            URL wsdlLocation = null;
            try {
                wsdlLocation = new URL(address + "?wsdl");
            } catch (Exception e) { System.exit(0); }
            UserAndPaymentService us = new UserAndPaymentService(wsdlLocation);
            IUserAndPaymentService userWs = us.getBasicHttpBindingIUserAndPaymentService();
            ((BindingProvider) userWs).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, address);
            //TODO
            if(userWs.isConnectionOK(email, password)/*fakeAuth(email, password)*/){
                connection =new Connection();
                connection.setUserEmail(email);
                connection.setTimeStamp(new Date().getTime());
                entityManager.persist(connection);
                System.out.println("### - NEW CONNECTION");
                return true;
            }else{
                System.out.println("### - UNABLE TO CONNECT");
                return false;
            }
        }
    }

    @Override
    public Connection getLastConnection(String email) {
        Connection result = null;
        for (Connection connection : findAllConnections())
            if (connection.getUserEmail().equals(email) && (result == null || connection.getTimeStamp()>result.getTimeStamp()))
                result=connection;
        return result;
    }

    @Override
    public boolean isConnected(String email) {
        Connection lastConnection = getLastConnection(email);
        if (lastConnection == null) return false;
        return isStillValid(lastConnection);
    }

    @Override
    public boolean isStillValid(Connection connection) {
        return connection.getTimeStamp()+TIMEOUT>new Date().getTime();
    }

    @Override
    public void cleanConnections() {
        List<Connection> allConnections = findAllConnections();
        for (Connection connection : allConnections)
            if (!isStillValid(connection))
                entityManager.remove(connection);
    }

    @Override
    public List<Connection> findAllConnections() {
        return entityManager.createQuery("select object(o) from Connection as o").getResultList();
    }

    private boolean fakeAuth(String email, String password) {
        String expectedPassword = ((email.length()>=3)?email.substring(0,3):email).toUpperCase()+"password";
        System.out.println("Expected psswrd : " + expectedPassword);
        return password.equals(expectedPassword);
    }
}
