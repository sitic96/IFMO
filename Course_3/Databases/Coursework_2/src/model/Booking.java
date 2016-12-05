package model;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by sitora on 29.11.16.
 */
public class Booking extends MongoObject {

    private static HashSet<String> params;
    private static HashMap<String,String> foreign_keys;

    static {
        foreign_keys = new HashMap<>();
        foreign_keys.put("cat_id", "Cat");
        foreign_keys.put("room_category", "Room");
        params = new HashSet<>();
        params.add("cat_id");
        params.add("from");
        params.add("to");
        params.add("room_category");
        params.add("price");
    }

    private String id;
    private String cat_id;
    private String from;
    private String to;
    private String room_category;
    private Integer price;

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
        return foreign_keys;
    }

    public String getCat_id() {
        return cat_id;
    }

    public void setCat_id(String cat_id) {
        this.cat_id = cat_id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getRoom_category() {
        return room_category;
    }

    public void setRoom_category(String room_category) {
        this.room_category = room_category;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
