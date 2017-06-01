package generator;

import connectors.MongoConnector;
import connectors.MySQLConnector;
import data.Airport;

import java.sql.SQLException;

/**
 * Created by sitora on 05.05.17.
 */
public class Generator {
    private static Airport[] airports;

    public static void main(String[] args) throws SQLException {
        airports = AirportGenerator.getAirports();
        //AirportCodeGenerator.generate(6000);
        //System.out.println("Codes generated!");
        //generateMongoData();
        System.out.println("Mongo ready!");
        //generateNeo4jData();
        System.out.println("Neo4j ready!");
        //generateMySQLData();
        System.out.println("MySQL ready!");
        generateCassandraData();
        System.out.println("Cassandra ready!");
    }

    public static void generateMongoData() {
        AirportInfoGenerator airportInfoGenerator = new AirportInfoGenerator();
        for (Airport airport : airports) {
            //airport.setInfo(airportInfoGenerator.generate(airport));
            for (int i = 0; i < 200; i++) {
                MongoConnector.getInstance().save(airportInfoGenerator.generate(airport));
            }
        }
//        AirportInfoGenerator airportInfoGenerator = new AirportInfoGenerator();
//        for (AirportInfo info : airportInfoGenerator.generate(850000)) {
//            MongoConnector.getInstance().save(info);
//        }
    }

    public static void generateNeo4jData() {
        Neo4jDataGenerator neo4jDataGenerator = new Neo4jDataGenerator();
        for (Airport airport : airports) {
            neo4jDataGenerator.generateNode(airport);
        }
        for (Airport airport : airports) {
            neo4jDataGenerator.generateReference(airport);
        }
        //neo4jDataGenerator.generate(AirportCodeGenerator.getCodesCount());
    }

    public static void generateMySQLData() throws SQLException {
        for (Airport airport : airports) {
            MySQLConnector.getInstance().save(airport);
        }
    }

    public static void generateCassandraData() {
        for (Airport airport : airports) {
            for (int i = 0; i < 50; i++) {
                CassandraGenerator.generate(airport);
            }
        }
    }
}
