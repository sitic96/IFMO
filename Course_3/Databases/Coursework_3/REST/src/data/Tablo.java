package data;

import connectors.MongoConnector;
import connectors.MySQLConnector;
import connectors.RedisConnector;
import data.enums.Status;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by sitora on 31.05.17.
 */
public class Tablo {
    List<Flight> arrival;
    List<Flight> departure;

    public List<Flight> getArrival() {
        return arrival;
    }

    public void setArrival(List<Flight> arrival) throws SQLException {
        for (Flight f : arrival) {
            this.changeStatus(f, f.getStatus());
        }
        this.arrival = arrival;
    }

    public List<Flight> getDeparture() {
        return departure;
    }

    public void setDeparture(List<Flight> departure) throws SQLException {
        for (Flight f : departure) {
            this.changeStatus(f, f.getStatus());
        }
        this.departure = departure;
    }

    public void changeStatus(Flight flight, Status status) throws SQLException {
        if (status == Status.BOARDING || status == Status.CHECK_IN || status == Status.BAGGAGE) {
            flight.setStatus(status);
            RedisConnector.getInstance().save(flight);
        } else if (status == Status.DELAYED || status == Status.DEPARTURED) {
            flight.setStatus(status);
            RedisConnector.getInstance().remove(flight);
            MongoConnector.getInstance().save(flight);
        } else if (status == Status.CANCELED || status == Status.LANDED) {
            flight.setStatus(status);
            RedisConnector.getInstance().remove(flight);
            MongoConnector.getInstance().remove(flight);
            MySQLConnector.getInstance().save(flight);

        }
    }
}
