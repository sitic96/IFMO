package model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by sitora on 29.11.16.
 */
public class Room extends MongoObject implements Serializable {
    public Room() {
    }

    private final static HashSet<String> params;
    private final static HashMap<String, String> foreign_keys;

    static {
        foreign_keys = null;
        params = new HashSet<>();
        params.add("roomPricePerNight");
        params.add("roomCategory");
    }

    private String id;
    private Boolean hasLinks;
    private Double roomPricePerNight;
    private String roomCategory;

    public Room(String roomCategory, Double roomPricePerNight) {
        this.roomCategory = roomCategory;
        this.roomPricePerNight = roomPricePerNight;
    }

    @Override
    public HashSet<String> getParams() {
        return params;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public HashMap<String, String> getForeign_keys() {
        return null;
    }

    public Double getRoomPricePerNight() {
        return roomPricePerNight;
    }

    public void setRoomPricePerNight(Double roomPricePerNight) {
        this.roomPricePerNight = roomPricePerNight;
    }

    public String getRoomCategory() {
        return roomCategory;
    }

    public void setRoomCategory(String roomCategory) {
        this.roomCategory = roomCategory;
    }

    public Boolean getHasLinks() {
        return hasLinks;
    }

    public void setHasLinks(Boolean hasLinks) {
        this.hasLinks = hasLinks;
    }
}
