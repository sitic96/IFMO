package converter;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import model.BookingInfo;
import model.MongoObject;
import org.apache.commons.beanutils.BeanUtils;
import org.bson.types.ObjectId;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;

public class DBObjectConverter {

    public static DBObject toDBObject(BookingInfo bookingInfo) {
        BasicDBObjectBuilder builder = BasicDBObjectBuilder.start();
        if (bookingInfo.getId() != null) {
            builder = builder.append("_id", new ObjectId(bookingInfo.getId()));
        }
        builder.append("cat", toDBObject(bookingInfo.getCat(), bookingInfo.getCat().getParams()));
        builder.append("host", toDBObject(bookingInfo.getHost(), bookingInfo.getHost().getParams()));
        builder.append("room", toDBObject(bookingInfo.getRoom(), bookingInfo.getRoom().getParams()));
//          builder.append("price", bookingInfo.getPrice());

        DBObject a = builder.get();
        return builder.get();
    }

    private static DBObject toDBObject(MongoObject mongoObject, HashSet<String> values) {
        BasicDBObjectBuilder builder = BasicDBObjectBuilder.start();
        for (String string : values) {
            if (mongoObject.getId() != null) {
                builder = builder.append("_id", new ObjectId(mongoObject.getId()));
            } else {
                try {
                    if (string == "roomPricePerNight") {
                        builder.append("roomPricePerNight", Double.parseDouble(BeanUtils.getProperty(mongoObject, string)));
                    } else {
                        builder.append(string, BeanUtils.getProperty(mongoObject, string));
                    }

                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
        }
        return builder.get();
    }

    public static BookingInfo toObject(DBObject doc) {
        BookingInfo bookingInfo = null;
        bookingInfo = new BookingInfo();
        for (String s : doc.keySet()) {
            switch (s) {
                case "_id": {
                    ObjectId id = (ObjectId) doc.get("_id");
                    bookingInfo.setId(id.toString());
                    break;
                }
                case "cat": {
                    try {
                        BeanUtils.setProperty(bookingInfo, "cat", toObject((DBObject) doc.get(s), "Cat"));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "host": {
                    try {
                        BeanUtils.setProperty(bookingInfo, "host", toObject((DBObject) doc.get(s), "Host"));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "room": {
                    try {
                        BeanUtils.setProperty(bookingInfo, "room", toObject((DBObject) doc.get(s), "Room"));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                default: {
                    try {
                        BeanUtils.setProperty(bookingInfo, s, doc.get(s));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return bookingInfo;
    }

    private static MongoObject toObject(DBObject doc, String tableName) {
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