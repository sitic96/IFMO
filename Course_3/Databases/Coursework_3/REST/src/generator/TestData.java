package generator;

import connectors.MongoConnector;
import connectors.RedisConnector;
import data.AirportInfo;
import data.Condition;

import java.util.List;

/**
 * Created by sitora on 09.04.17.
 */
public class TestData {
    public static void generate(int count, DB db) {
        if (count > 0) {
            switch (db) {
                case MONGO: {
                    createMongoData(count);
                }
                case MYSQL: {

                }
                case REDIS: {
                    createRedisData(count);
                }
                case NEO4J: {

                }
                case CASSANDRA: {

                }
            }
        } else throw new IllegalArgumentException("Non positive count");
    }

    private static void createRedisData(int count) {
        AirportInfoGenerator airportInfoGenerator = new AirportInfoGenerator();
        List<Condition> conditions = airportInfoGenerator.generateConditions(count);
        for (Condition condition : conditions) {
            RedisConnector.getInstance().save(condition);
        }
    }

    private static void createMongoData(int count) {
        AirportInfoGenerator generator = new AirportInfoGenerator();
        List<AirportInfo> infos = generator.generate(count);
        for (AirportInfo info : infos) {
            MongoConnector.getInstance().save(info);
        }
    }
}
