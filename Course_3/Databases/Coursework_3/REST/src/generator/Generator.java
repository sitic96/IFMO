package generator;

import connectors.MongoConnector;
import data.AirportInfo;

/**
 * Created by sitora on 05.05.17.
 */
public class Generator {
    public static void main(String[] args) {
        AirportCodeGenerator.generate(40000);
        //generateMongoData();
        System.out.println("Mongo ready!");
        //generateNeo4jData();
        System.out.println("Neo4j ready!");
        generateMySQLData();
        System.out.println("MySQL ready!");
    }

    public static void generateMongoData() {
        AirportInfoGenerator airportInfoGenerator = new AirportInfoGenerator();
        for (AirportInfo info : airportInfoGenerator.generate(850000)) {
            MongoConnector.getInstance().save(info);
        }
    }

    public static void generateNeo4jData() {
        Neo4jDataGenerator neo4jDataGenerator = new Neo4jDataGenerator();
        neo4jDataGenerator.generate(AirportCodeGenerator.getCodesCount());
    }

    public static void generateMySQLData() {
        MySQLDataGenerator.generate();
    }
}
