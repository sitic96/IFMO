package connectors;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import data.Worker;

import java.util.ArrayList;
import java.util.List;

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
        cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
        session = cluster.connect("workers");
    }

    public void save(Worker worker) {
        session.execute("INSERT INTO workers (firstname, lastname, city, airportcode) VALUES ('" + worker.getFirstName()
                + "', '" + worker.getSecondName() + "', '" + worker.getCity().replace('\'', ' ') + "', '" + worker.getAirportCode() + "')");
    }

    public List<Worker> get(String name, String lastName) {
        List<Worker> workers = new ArrayList<>();
        ResultSet results = session.execute("SELECT * FROM workers WHERE firstname='" + name + "' AND lastname = '" + lastName + "'");
        for (Row row : results) {
            workers.add(new Worker(row.getString("firstname"), row.getString("lastname"), row.getString("city"), row.getString("airportcode")));
        }
        return workers;
    }

    public void remove(String firstName, String lastName) {
        session.execute("DELETE FROM Workers where firstname = '" + firstName + "' AND lastname = '" + lastName + "'");
    }

    public static CassandraConnector getInstance() {
        if (instance == null) {
            instance = new CassandraConnector();
        }
        return instance;
    }
}
