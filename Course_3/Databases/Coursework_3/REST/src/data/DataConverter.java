package data;

import com.mongodb.DBObject;
import org.bson.types.ObjectId;

/**
 * Created by sitora on 03.05.17.
 */
public class DataConverter {
    public static AirportInfo toAirportInfo(DBObject dbObject) {
        AirportInfo airportInfo = null;
        airportInfo = new AirportInfo();

        ObjectId objectId = (ObjectId) dbObject.get("_id");
        airportInfo.setId(objectId.toString());
        airportInfo.setAirport((String) dbObject.get("airport"));
        //todo do do do
        return null;
    }
}
