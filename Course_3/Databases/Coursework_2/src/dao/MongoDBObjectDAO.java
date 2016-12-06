package dao;

import com.mongodb.*;
import converter.DBObjectConverter;
import model.MongoObject;
import org.apache.commons.beanutils.BeanUtils;
import org.bson.types.ObjectId;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class MongoDBObjectDAO {

    private DBCollection col;
    private String tableName;

    public MongoDBObjectDAO(MongoClient mongo, String tableName) {
        this.col = mongo.getDB("journaldev").getCollection(tableName + "s");
        this.tableName = tableName;
    }

    public MongoObject createMongoObject(MongoObject mongoObject) {
        DBObject doc = DBObjectConverter.toDBObject(mongoObject, mongoObject.getParams());
        this.col.insert(doc);
        ObjectId id = (ObjectId) doc.get("_id");
        mongoObject.setId(id.toString());
        return mongoObject;
    }

    public void createReference(MongoClient client, String referenceID, String tableName) {
        MongoObject temp = this.readMongoObjectByID(client, tableName, referenceID);
        if (temp == null) {
            try {
                temp = ((Class<? extends MongoObject>) Class.forName("model." + tableName)).newInstance();
                temp.setId(referenceID);
                BeanUtils.setProperty(temp, "hasLinks", true);
                this.createMongoObject(temp);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } else {
            try {
                BeanUtils.setProperty(temp, "hasLinks", true);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            this.updateMongoObject(temp);
        }
    }

    public void updateMongoObject(MongoObject mongoObject) {
        DBObject query = BasicDBObjectBuilder.start()
                .append("_id", new ObjectId(mongoObject.getId())).get();
        this.col.update(query, DBObjectConverter.toDBObject(mongoObject, mongoObject.getParams()));
    }

    public List<MongoObject> readAllMongoObjects(String tableName) {
        List<MongoObject> data = new ArrayList<>();
        DBCursor cursor = col.find();
        while (cursor.hasNext()) {
            DBObject doc = cursor.next();
            MongoObject mongoObject = DBObjectConverter.toObject(doc, tableName);
            data.add(mongoObject);
        }
        return data;
    }

    public void deleteMongoObject(MongoObject p) {
        DBObject query = BasicDBObjectBuilder.start()
                .append("_id", new ObjectId(p.getId())).get();
        DBObject data = this.col.findOne(query);
        if (data != null) {
            DBObjectConverter.toObject(data, tableName);
        }
        this.col.remove(query);
    }

    public MongoObject readMongoObject(MongoObject p, String tableName) {
        DBObject query = BasicDBObjectBuilder.start()
                .append("_id", new ObjectId(p.getId())).get();
        DBObject data = this.col.findOne(query);
        return DBObjectConverter.toObject(data, tableName);
    }

    public MongoObject readMongoObjectByID(MongoClient client, String tableName, String id) {
        DBCollection collection = client.getDB("journaldev").getCollection(tableName + "s");
        DBObject query = BasicDBObjectBuilder.start()
                .append("_id", new ObjectId(id)).get();
        DBObject data = collection.findOne(query);
        if (data != null) {
            return DBObjectConverter.toObject(data, tableName);
        } else return null;
    }

}
