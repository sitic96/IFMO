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
        for (int i=0;i<1000000;i++){
            try {
                MySQLConnector.getInstance().save(AirportCodeGenerator.getRandomCode(), CityGenerator.getRandomCity().getName());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
//        for (String code : AirportCodeGenerator.getCodes()) {
//            try {
//                MySQLConnector.getInstance().save(code, CityGenerator.getRandomCity().getName());
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
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
