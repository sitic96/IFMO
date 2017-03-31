package data;

import data.enums.Airport;
import redis.clients.johm.Attribute;
import redis.clients.johm.Model;

import java.time.LocalDate;

/**
 * Created by sitora on 27.03.17.
 */
@Model
public class AirportInfo {
    @Attribute
    private String id;
    @Attribute
    private Airport airport;
    @Attribute
    private Condition condition;
    @Attribute
    private LocalDate date;

    public AirportInfo() {
    }

    public AirportInfo(Airport airport, Condition condition, LocalDate date) {
        this.airport = airport;
        this.condition = condition;
        this.date = date;
    }

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
