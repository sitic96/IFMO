package data;

import com.mongodb.DBObject;
import data.conditions.Wind;
import data.enums.Speed;
import org.bson.types.ObjectId;

import java.util.Date;

/**
 * Created by sitora on 03.05.17.
 */
public class DataConverter {
    public static AirportInfo toAirportInfo(DBObject dbObject) {
        AirportInfo airportInfo;
        airportInfo = new AirportInfo();

        ObjectId objectId = (ObjectId) dbObject.get("_id");
        airportInfo.setId(objectId.toString());
        airportInfo.setAirport((String) dbObject.get("airport"));
        airportInfo.setDate((Date)dbObject.get("date"));
        airportInfo.setCondition(toAirportConditions((DBObject) dbObject.get("condition")));
        return airportInfo;
    }

    private static Condition toAirportConditions(DBObject object) {
        Condition condition = new Condition();
        condition.setWeatherPhenomena(object.get("weatherPhenomena").toString());
        condition.setIKAO(object.get("IKAO").toString());
        condition.setPressure(object.get("pressure").toString());
        condition.setType(object.get("type").toString());
        condition.setTime(object.get("time").toString());
        condition.setVisibility(object.get("visibility").toString());
        condition.setSkyCondition(object.get("skyCondition").toString());
        condition.setTemperature(object.get("temperature").toString());
        condition.setWind(toWind((DBObject) object.get("wind")));
        return condition;
    }

    private static Wind toWind(DBObject object) {
        Wind wind = new Wind();
        wind.setDest((Integer.parseInt(object.get("dest").toString())));
        wind.setMaxObservedSpeed(Integer.parseInt(object.get("maxObservedSpeed").toString()));
        wind.setSpeed(Integer.parseInt(object.get("speed").toString()));
        wind.setSpeedType(Speed.valueOf(object.get("speedType").toString()));
        return wind;
    }
}
