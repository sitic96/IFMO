import DBWorker.Factory;
import redis.clients.jedis.Jedis;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("=========Available Tables:=========");
//        DBUtils.getTABLES().forEach(System.out::println);
//        while (true) {
//            System.out.println("Table name:");
//            String tableName = scanner.nextLine();
//            HashSet<String> params = DBUtils.getParameteres(tableName);
//            Map<String, Object> elements = new HashMap<>();
//            for (String param : params) {
//                System.out.println(param);
//                elements.put(param, scanner.next());
//            }
//            DBUtils.addInTable("Person", elements);
//        }

        Jedis jedis = new Jedis("localhost");
        Collection collection = Factory.getInstance().getPersonDAO().getAllElements();
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()){
            jedis.sadd("allPersons", iterator.next().toString());
        }

        if(jedis.exists("allPersons")){
            Collection c = jedis.smembers("allPersons");
        }
    }
}




















