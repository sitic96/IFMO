package generator;

import connectors.Neo4jConnector;

import javax.xml.ws.WebServiceException;
import java.util.Random;

/**
 * Created by sitora on 28.04.17.
 */
public class Neo4jDataGenerator {
    private Random rnd;

    public Neo4jDataGenerator() {
        rnd = new Random();
    }

    public void generate(int count) {
        if (count <= 0) {
            throw new WebServiceException("Count cant't be less than 1");
        }
        for (int j = 0; j < AirportCodeGenerator.getCodesCount(); j++) {
            Neo4jConnector.getInstance().save(AirportCodeGenerator.getCodes().get(j));
            if (j > 100) {
                for (int i = 0; i < rnd.nextInt(j / 100); i++) {
                    Neo4jConnector.getInstance().addReference(AirportCodeGenerator.getCodes().get(j), AirportCodeGenerator.getRandomCode());
                }
            }
        }
    }
}
