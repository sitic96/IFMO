package generator;

import connectors.Neo4jConnector;

import javax.xml.ws.WebServiceException;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by sitora on 28.04.17.
 */
public class Neo4jDataGenerator {
    private HashMap<Integer, String> airports;
    private Random rnd;
    private StringBuilder sb = new StringBuilder();
    char[] chars = "QWERTYUIOPLKJHGFDSAZXCVBNM".toCharArray();

    public Neo4jDataGenerator() {
        rnd = new Random();
    }

    public void generate(int count) {
        if (count <= 0) {
            throw new WebServiceException("Count cant't be less than 1");
        }
        airports = new HashMap<>();
        generateData(count);
        for (int j = 0; j < airports.size(); j++) {
            Neo4jConnector.getInstance().save(airports.get(j));
            if (j>100) {
                for (int i = 0; i < rnd.nextInt(j / 100); i++) {
                    Neo4jConnector.getInstance().addReference(airports.get(j), airports.get(rnd.nextInt(j)));
                }
            }
        }
    }

    private void generateData(int count) {
        while (count > airports.size()) {
            sb = new StringBuilder();
            for (int j = 0; j < 5; j++) {
                sb.append(chars[rnd.nextInt(chars.length)]);
            }
            airports.put(airports.size(), sb.toString());
        }
    }
}
