package connectors;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import data.enums.Airport;

import javax.xml.ws.WebServiceException;
import java.sql.SQLException;

/**
 * Created by sitora on 09.04.17.
 */
public class MySQLConnector implements Connector {
    private MysqlDataSource DATA_SOURCE;
    private static MySQLConnector instance;

    public static MySQLConnector getInstance() {
        if (instance == null) {
            instance = new MySQLConnector();
        }
        return instance;
    }

    @Override
    public void connect() {
        DATA_SOURCE = new MysqlDataSource();
        DATA_SOURCE.setUser("root");
        DATA_SOURCE.setPassword("root");
        DATA_SOURCE.setPort(8889);
        DATA_SOURCE.setDatabaseName("Airports");
        DATA_SOURCE.setServerName("localhost");
    }

    public void save(Airport airport) {
        try {
            DATA_SOURCE.getConnection().createStatement().
                    executeUpdate("INSERT INTO `Airport` (`ikao`, `iata`, `city`) VALUES (`" + airport.getIkao() +
                            "`, `" + airport.getCode() + "`, `" + airport.getCity() + "`)");
        } catch (SQLException e) {
            throw new WebServiceException();
        }
    }
}
