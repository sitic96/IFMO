package converter;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import model.MongoObject;
import org.apache.commons.beanutils.BeanUtils;
import org.bson.types.ObjectId;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;

public class DBObjectConverter {

    public static DBObject toDBObject(MongoObject mongoObject, HashSet<String> values) {
        BasicDBObjectBuilder builder = BasicDBObjectBuilder.start();
        for (String string : values) {
            if (mongoObject.getId() != null) {
                builder = builder.append("_id", new ObjectId(mongoObject.getId()));
            } else {
                try {
                    builder.append(string, BeanUtils.getProperty(mongoObject, string));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
//                if (values.get(string) instanceof Integer) {
//                    builder = builder.append(string, (Integer) values.get(string));
//
//                } else {
//                    builder = builder.append(string, values.get(string));
//                }
            }
        }
        return builder.get();
    }

//    public static DBObject toDBObject(Host p) {
//
//        BasicDBObjectBuilder builder = BasicDBObjectBuilder.start()
//                .append("name", p.getName()).append("country", p.getPhone_number());
//        if (p.getId() != null)
//            builder = builder.append("_id", new ObjectId(p.getId()));
//        return builder.get();
//    }

    public static MongoObject toObject(DBObject doc, String tableName) {
        MongoObject mongoObject = null;
        try {
            mongoObject = ((Class<? extends MongoObject>) Class.forName("model." + tableName)).newInstance();
            for (String value : doc.keySet()) {
                if (value.equals("_id")) {
                    ObjectId id = (ObjectId) doc.get("_id");
                    mongoObject.setId(id.toString());
                } else {
                    if (doc.get(value) instanceof Integer) {
                        BeanUtils.setProperty(mongoObject, value, (Integer) doc.get(value));
                    } else {
                        BeanUtils.setProperty(mongoObject, value, doc.get(value));
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return mongoObject;
    }
}