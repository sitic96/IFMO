package connectors;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import data.Airport;
import data.City;
import data.Flight;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.xml.ws.WebServiceException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by sitora on 09.04.17.
 */
public class MySQLConnector implements Connector {
    private static MysqlDataSource DATA_SOURCE;
    private static MySQLConnector instance;

    private MySQLConnector() {
        this.connect();
    }

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

    private static java.sql.PreparedStatement statement;
    private static Connection connection;

    public static void save(String city) throws SQLException {
        try {
            connection = DATA_SOURCE.getConnection();
            connection.createStatement().
                    executeUpdate("INSERT INTO `Cities` (`name` ) VALUES (\"" + city + "\")");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
//        try {
//            connection = DATA_SOURCE.getConnection();
//            statement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
//            statement.setString(1, "name");
//            statement.setString(2, city);
//            int affectedRows = statement.executeUpdate();
//            if (affectedRows > 0) {
//                return affectedRows;
//            } else {
//                throw new WebServiceException();
//            }
//        } catch (SQLException e) {
//            throw new WebServiceException();
//        } finally {
//            if (statement != null) statement.close();
//            if (connection != null) connection.close();
//        }
    }

    public static void save(String code, String city) throws SQLException {
        try {
            connection = DATA_SOURCE.getConnection();
            connection.createStatement().
                    executeUpdate("INSERT INTO `Airport` (`code`, `city`) VALUES (\"" + code +
                            "\", \"" + getCityById(city) + "\")");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }

    private static Integer getCityById(String city) {
        Integer id = -1;
        try {
            ResultSet resultSet = DATA_SOURCE.getConnection().createStatement().executeQuery("SELECT `id` from `Cities` WHERE `name` like \"" + city + "\" ;");
            while (resultSet.next()) {
                id = resultSet.getInt("id");
            }
        } catch (SQLException e) {
        }
        return id;
    }

    public static void save(Airport airport) throws SQLException {
        try {
            connection = DATA_SOURCE.getConnection();
            connection.createStatement().
                    executeUpdate("INSERT IGNORE INTO `Cities` (`name` ) VALUES (\"" + airport.getHome_city() + "\")");
            connection.createStatement().executeUpdate("INSERT INTO `Airport` (`city`, `code`, `name`, `runway_length`, " +
                    "`direct_flights`, `carrier`, `IKAO`) VALUES (" +
                    "(SELECT max(`id`) from `Cities` where `name` = \"" + airport.getHome_city() + "\"), \"" +
                    airport.getCode() + "\", \"" +
                    airport.getName() + "\", " +
                    airport.getRunway_length() + ", " +
                    airport.getDirect_flights() + ", " +
                    airport.getCarriers() + ", \"" +
                    airport.getIcao() + "\"" + ")");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }

    public static Airport get(String code) {
        try {
            connection = DATA_SOURCE.getConnection();
            QueryRunner run = new QueryRunner(DATA_SOURCE);
            ResultSetHandler<List<Airport>> h = new BeanListHandler<>((Class<Airport>) Class.forName("data.Airport"));
            List<Airport> query = run.query("SELECT * FROM `Airport` where code = \"" + code + "\"", h);
            List<City> cities = run.query("select * from `Cities` where id = " + query.get(0).getCity(), new BeanListHandler<City>(City.class));
            query.get(0).setHome_city(cities.get(0).getName());
            return query.get(0);

        } catch (SQLException e) {
            throw new WebServiceException();
        } catch (ClassNotFoundException e) {
            throw new WebServiceException();
        }
    }

    public static void remove(String code) throws SQLException {
        connection = DATA_SOURCE.getConnection();
        connection.createStatement().executeUpdate("DELETE FROM `Airport` WHERE `code` = \"" + code + "\"");

    }

    public static void update(Airport airport) throws SQLException {
        String sql = "UPDATE `Airport` SET "
                + "`name`=\"" + airport.getName() + "\", " +
                "`runway_length`=" + airport.getRunway_length() + ", " +
                "`direct_flights`=" + airport.getDirect_flights() + ", " +
                "`carrier`=" + airport.getCarriers() + ", " +
                "where `code` = \"" + airport.getCode() + "\"";
        connection = DATA_SOURCE.getConnection();
        connection.createStatement().executeUpdate("UPDATE `Airport` SET "
                + "`name`=\"" + airport.getName() + "\", " +
                "`runway_length`=" + airport.getRunway_length() + ", " +
                "`direct_flights`=" + airport.getDirect_flights() + ", " +
                "`carrier`=" + airport.getCarriers() + " " +
                "where `code` = \"" + airport.getCode() + "\"");
    }

    public void save(Flight flight) throws SQLException {
        try {

            java.sql.Date sqlDate = new java.sql.Date(flight.getDate().getTime());

            connection = DATA_SOURCE.getConnection();

            connection.createStatement().executeUpdate("INSERT INTO `Flight`(`code`, `date`, `from_ap`, `to_ap`, `status`) VALUES " +
                    "(\"" + flight.getCode() + "\"," +
                    "\"" + flight.getDate() + "\"," +
                    "\"" + flight.getFrom() + "\"," +
                    "\"" + flight.getTo() + "\"," +
                    "\"" + flight.getStatus() + "\")");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }
}
