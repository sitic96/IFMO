package dao;

import com.mongodb.*;
import converter.DBObjectConverter;
import model.BookingInfo;
import model.MongoObject;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class MongoDBObjectDAO {

    private DBCollection col;
    private String tableName;

    public MongoDBObjectDAO(MongoClient mongo, String tableName) {
        this.col = mongo.getDB("hotel").getCollection(tableName + "s");
        this.tableName = tableName;
    }

    public BookingInfo createMongoObject(BookingInfo bookingInfo) {
        DBObject doc = DBObjectConverter.toDBObject(bookingInfo);
        this.col.insert(doc);
        ObjectId id = (ObjectId) doc.get("_id");
        bookingInfo.setId(id.toString());
        return bookingInfo;
    }

    public void updateMongoObject(BookingInfo bookingInfo) {
        DBObject query = BasicDBObjectBuilder.start()
                .append("_id", new ObjectId(bookingInfo.getId())).get();
        this.col.update(query, DBObjectConverter.toDBObject(bookingInfo));
    }

    public List<BookingInfo> readAllMongoObjects(String tableName) {
        List<BookingInfo> data = new ArrayList<>();
        DBCursor cursor = col.find();
        while (cursor.hasNext()) {
            DBObject doc = cursor.next();
            BookingInfo mongoObject = DBObjectConverter.toObject(doc);
            data.add(mongoObject);
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
        this.col.remove(query);
    }

    public BookingInfo readMongoObject(MongoObject p, String tableName) {
        DBObject query = BasicDBObjectBuilder.start()
                .append("_id", new ObjectId(p.getId())).get();
        DBObject data = this.col.findOne(query);
        return DBObjectConverter.toObject(data);
    }

    public BookingInfo readMongoObjectByID(MongoClient client, String tableName, String id) {
        DBCollection collection = client.getDB("hotel").getCollection(tableName + "s");
        DBObject query = BasicDBObjectBuilder.start()
                .append("_id", new ObjectId(id)).get();
        DBObject data = collection.findOne(query);
        if (data != null) {
            return DBObjectConverter.toObject(data);
        } else return null;
    }

}
