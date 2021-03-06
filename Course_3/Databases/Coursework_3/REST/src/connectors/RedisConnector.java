package connectors;

import data.Condition;
import data.Flight;
import redis.clients.jedis.Jedis;

/**
 * Created by sitora on 29.03.17.
 */
public class RedisConnector implements Connector {
    private Jedis jedis;
    private static RedisConnector instance;

    private RedisConnector() {
        this.connect();
    }

    public static RedisConnector getInstance() {
        if (instance != null) {
            return instance;
        } else {
            instance = new RedisConnector();
            return instance;
        }
    }

    @Override
    public void connect() {
        jedis = new Jedis("localhost");
    }

    public void save(Condition airportCondition) {
        jedis.set(airportCondition.getIKAO(), airportCondition.toString());
    }

    public void save(Flight flight){
        jedis.set(flight.getCode(), flight.getStatus().toString());
    }

    public void remove(Flight flight){
        jedis.del(flight.getCode());
    }
    public String get(String key){
        return jedis.get(key);
    }
}
