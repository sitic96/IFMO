import connectors.RedisConnector;

/**
 * Created by sitora on 27.03.17.
 */
public class Main {
    public static void main(String[] args) {
        RedisConnector redisConnector = RedisConnector.getInstance();
        redisConnector.getJedis().set("foo", "bar");
        redisConnector.getJedis().set("foo", "megaBar");
        System.out.println(redisConnector.getJedis().get("foo"));
    }
}
