package connectors;

import com.mysql.jdbc.Statement;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.xml.ws.WebServiceException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by sitora on 09.04.17.
 */
public class MySQLConnector implements Connector {
    private final static String SQL_INSERT = "INSERT into ? (`?`) VALUES (\"?\")";
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

    public static Integer save(String city) throws SQLException {
        try {
            connection = DATA_SOURCE.getConnection();
            statement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, "Cities");
            statement.setString(2, "name");
            statement.setString(3, city);
            int affectedRows = statement.executeUpdate();
            if ()
        } catch (SQLException e) {
            throw new WebServiceException();
        } finally {
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        }
    }

    public static void save(String code, String city) {
        try {
            DATA_SOURCE.getConnection().createStatement().
                    executeUpdate("INSERT INTO `Airport` (`code`, `city`) VALUES (`" + code +
                            "`, `" + getCityById(city) + "`)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Integer getCityById(String city) {
        Integer id = -1;
        try {
            ResultSet resultSet = DATA_SOURCE.getConnection().createStatement().executeQuery("SELECT `id` from `Cities` WHERE `name` like " + city + " ;");
            while (resultSet.next()) {
                id = resultSet.getInt("id");
            }
        } catch (SQLException e) {
            throw new WebServiceException("City doesn't exist");
        }
        return id;
    }
}
