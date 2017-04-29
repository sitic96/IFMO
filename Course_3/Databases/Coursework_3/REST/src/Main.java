import generator.Neo4jDataGenerator;

/**
 * Created by sitora on 27.03.17.
 */
public class Main {
    public static void main(String[] args) {
//        AirportInfoGenerator airportInfoGenerator = new AirportInfoGenerator();
//        //airportInfoGenerator.generate(100000);
//        for (AirportInfo info: airportInfoGenerator.generate(850000)){
//            MongoConnector.getInstance().save(info);
//        }
        //System.out.println(RedisConnector.getInstance().getJedis().get(""));

//        for (Airport airport : Airport.values()) {
//            System.out.println(airport.getIkao() + ":");
//            System.out.println(RedisConnector.getInstance().getJedis().get(airport.getIkao()));
//        }
//    }
//
//    private void testDataGenerator(){
//        AirportInfoGenerator airportInfoGenerator = new AirportInfoGenerator();
//        airportInfoGenerator.generate(100000);
//        for (Airport airport : Airport.values()) {
//            System.out.println(airport.getIkao() + ":");
//            System.out.println(RedisConnector.getInstance().getJedis().get(airport.getIkao()));
//        }
//    }
//
//    private void JOhmConnector(){
//        RedisConnector redisConnector = RedisConnector.getInstance();
//        JedisPool pool = new JedisPool(new GenericObjectPool.Config(), "localhost");
//        redisConnector.getJedis().set("foo", "bar");
//        redisConnector.getJedis().set("foo", "megaBar");
//        JOhm.setPool(pool);
//        JOhm.save(new Condition());
//        Condition info = JOhm.get(Condition.class, 1);
//        System.out.println(redisConnector.getJedis().get("foo"));
//    }
        Neo4jDataGenerator dataGenerator = new Neo4jDataGenerator();
        dataGenerator.generate(1000000);
    }
}
