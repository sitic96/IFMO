package generator;

import connectors.MySQLConnector;
import data.City;

import java.sql.SQLException;

/**
 * Created by sitora on 06.05.17.
 */
public class MySQLDataGenerator {
    public static void generate() {
        addCities();
        for (String code : AirportCodeGenerator.getCodes()) {
            MySQLConnector.getInstance().save(code, CityGenerator.getRandomCity().getName());
        }
    }
    private static void addCities() {
        for (City city : CityGenerator.getCities()) {
            try {
                MySQLConnector.getInstance().save(city.getName());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
