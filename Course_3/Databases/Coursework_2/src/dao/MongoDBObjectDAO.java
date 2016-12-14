package dao;

import com.mongodb.*;
import converter.DBObjectConverter;
import model.BookingInfo;
import org.bson.types.ObjectId;
import redis.clients.jedis.Jedis;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Set;
import java.util.TreeSet;

public class MongoDBObjectDAO {

    private DBCollection col;
    private Jedis jedis = new Jedis("localhost");

    public MongoDBObjectDAO(MongoClient mongo) {
        this.col = mongo.getDB("hotel").getCollection("BookingInfos");
    }

    public BookingInfo createMongoObject(BookingInfo bookingInfo) {
        DBObject doc = DBObjectConverter.toDBObject(bookingInfo);
        this.col.insert(doc);
        ObjectId id = (ObjectId) doc.get("_id");
        bookingInfo.setId(id.toString());
        jedis.set(("BookingInfo" + "isValid").getBytes(), new byte[]{0});
        return bookingInfo;
    }

    public void updateMongoObject(BookingInfo bookingInfo) {
        DBObject query = BasicDBObjectBuilder.start()
                .append("_id", new ObjectId(bookingInfo.getId())).get();
        this.col.update(query, DBObjectConverter.toDBObject(bookingInfo));
        jedis.set(("BookingInfo" + "isValid").getBytes(), new byte[]{0});
    }

    public Set<BookingInfo> readAllMongoObjects() {
        byte[] isCacheValid = jedis.get(("BookingInfo" + "isValid").getBytes());
        if (isCacheValid != null && isCacheValid[0] == 1) {
            byte[] cached = jedis.get("BookingInfo".getBytes());
            if (cached != null && cached.length > 0) {
                try {
                    ByteArrayInputStream bais = new ByteArrayInputStream(cached);
                    int length = bais.read();
                    ObjectInputStream ois = new ObjectInputStream(bais);
                    Set<BookingInfo> resultSet = new TreeSet();
                    for (int i = 0; i < length; i++) {
                        BookingInfo obj = (BookingInfo) ois.readObject();
                        resultSet.add(obj);
                    }
                    return resultSet;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        Set<BookingInfo> data = new TreeSet<>();
        DBCursor cursor = col.find();
        while (cursor.hasNext()) {
            DBObject doc = cursor.next();
            BookingInfo mongoObject = DBObjectConverter.toObject(doc);
            data.add(mongoObject);
        }
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            baos.write(data.size());
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            for (BookingInfo e : data) {
                oos.writeObject(e);
            }
            oos.close();
            jedis.set("BookingInfo".getBytes(), baos.toByteArray());
            jedis.set(("BookingInfo" + "isValid").getBytes(), new byte[]{1});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public void deleteMongoObject(BookingInfo p) {
        DBObject query = BasicDBObjectBuilder.start()
                .append("_id", new ObjectId(p.getId())).get();
        DBObject data = this.col.findOne(query);
        if (data != null) {
            DBObjectConverter.toObject(data);
        }
        jedis.set(("BookingInfo" + "isValid").getBytes(), new byte[]{0});
        this.col.remove(query);
    }

    public BookingInfo readMongoObject(BookingInfo p) {

        DBObject query = BasicDBObjectBuilder.start()
                .append("_id", new ObjectId(p.getId())).get();
        DBObject data = this.col.findOne(query);
        return DBObjectConverter.toObject(data);
    }

}
