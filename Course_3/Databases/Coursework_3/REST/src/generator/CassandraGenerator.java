package generator;

import connectors.CassandraConnector;
import data.Worker;

/**
 * Created by sitora on 12.05.17.
 */
public class CassandraGenerator {
    public static void generate(int count) {
        for (int i = 0; i < count; i++) {
            generate();
        }
    }

    private static void generate() {
        CassandraConnector.getInstance().save(new Worker(NamesGenerator.getRandomName(), NamesGenerator.getRandomName(),
                CityGenerator.getRandomCity(), AirportCodeGenerator.getRandomCode()));
    }
}
