package domain;

import entities.Connection;

import java.util.List;

/**
 * Created by Tom Veniat on 16/05/15.
 */
public interface Authentifier {
    /**
     *     default tiemout : 10 minutes.
     */
    long TIMEOUT=10*60*1000;

    boolean connect(String email, String password);
    Connection getLastConnection(String email);
    boolean isConnected(String email);
    boolean isStillValid(Connection connection);
    void cleanConnections();
    List<Connection> findAllConnections();

}
