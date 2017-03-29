package connectors;

import com.mongodb.*;
import data.AirportInfo;
import data.Condition;
import data.conditions.Wind;
import data.enums.Airport;
import org.bson.types.ObjectId;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created by sitora on 27.03.17.
 */
public class MongoConnector implements Connector {
    private static MongoConnector instance;
    private DB db;
    private DBCollection collection;

    public static MongoConnector getInstance() {
        if (instance == null) {
            instance = new MongoConnector();
        }
        return instance;
    }

    private MongoConnector() {
        this.connect();
    }

    public void connect() {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        db = mongoClient.getDB("airports");
        collection = db.getCollection("airports");
    }

//    @Override
//    public void save(Object o) {
//        if (o instanceof AirportInfo) {
//            this.save((AirportInfo) o);
//        } else throw new ClassCastException("Can't cast to AirportInfo");
//    }

    public void save(AirportInfo airportInfo) {
        collection.insert(toDBObject(airportInfo));
    }

    private Date convertLocalDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    private DBObject toDBObject(AirportInfo airportInfo) {
        BasicDBObjectBuilder builder = BasicDBObjectBuilder.start();
        if (airportInfo.getId() != null) {
            builder = builder.append("id", new ObjectId(airportInfo.getId()));
        }
        builder.append("airport", toDBObject(airportInfo.getAirport()));
        builder.append("date", convertLocalDate(airportInfo.getDate()));
        builder.append("condition", toDBObject(airportInfo.getCondition()));

        return builder.get();
    }

    private DBObject toDBObject(Airport airport) {
        BasicDBObjectBuilder builder = BasicDBObjectBuilder.start();
        builder.append("code", airport.getCode());
        builder.append("ikao", airport.getIkao());
        builder.append("city", airport.getCity());
        return builder.get();
    }

    private DBObject toDBObject(Condition condition) {
        BasicDBObjectBuilder builder = BasicDBObjectBuilder.start();
        builder.append("type", condition.getType().toString());
        builder.append("IKAO", condition.getIKAO());
        builder.append("time", condition.getTime().toString());
        builder.append("wind", toDBObject(condition.getWind()));
        builder.append("visibility", condition.getVisibility().toString());
        builder.append("weatherPhenomena", condition.getWeatherPhenomena().toString());
        builder.append("skyCondition", condition.getSkyCondition().toString());
        builder.append("temperature", condition.getTemperature().toString());
        builder.append("pressure", condition.getPressure().toString());
        return builder.get();
    }

    private DBObject toDBObject(Wind wind) {
        BasicDBObjectBuilder builder = BasicDBObjectBuilder.start();
        builder.append("dest", wind.getDest());
        builder.append("speed", wind.getSpeed());
        builder.append("maxObservedSpeed", wind.getMaxObservedSpeed());
        builder.append("speedType", wind.getSpeedType().toString());
        return builder.get();
    }
}
