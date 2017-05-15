package connectors;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
