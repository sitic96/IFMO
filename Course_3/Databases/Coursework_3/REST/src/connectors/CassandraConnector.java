package connectors;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import data.Worker;

/**
 * Created by sitora on 12.05.17.
 */
public class CassandraConnector implements Connector {

    public static CassandraConnector instance;
    Cluster cluster;
    Session session;

    private CassandraConnector() {
        this.connect();
    }

    @Override
    public void connect() {
        //cluster =  Cluster
        cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
        //session = cluster.connect();
        session = cluster.connect("workers");
    }

    public void save(Worker worker) {
        session.execute("INSERT INTO workers (firstname, lastname, city, airportcode) VALUES ('" + worker.getFirstName()
                + "', '" + worker.getSecondName() + "', '" + worker.getCity().getName().replace('\'', ' ') + "', '" + worker.getAirportCode() + "')");
    }

    public static CassandraConnector getInstance() {
        if (instance == null) {
            instance = new CassandraConnector();
        }
        return instance;
    }
}
