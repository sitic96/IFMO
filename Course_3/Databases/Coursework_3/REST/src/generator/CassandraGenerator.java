package generator;

import connectors.CassandraConnector;
import data.Airport;
import data.Worker;

/**
 * Created by sitora on 12.05.17.
 */
public class CassandraGenerator {
    public static void generate(Airport airport) {
        CassandraConnector.getInstance().save(new Worker(NamesGenerator.getRandomName(), NamesGenerator.getRandomName(),
                airport.getHome_city(), airport.getCode()));
    }
}
