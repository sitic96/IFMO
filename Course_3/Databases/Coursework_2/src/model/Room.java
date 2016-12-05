package model;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by sitora on 29.11.16.
 */
public class Room extends MongoObject {

    private final static HashSet<String> params;
    private final static HashMap<String, String> foreign_keys;

    static {
        foreign_keys = null;
        params = new HashSet<>();
        params.add("price_per_night");
        params.add("category_name");
    }

    private String id;
    private Boolean hasLinks;
    private String price_per_night;
    private String category_name;

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

    public String getPrice_per_night() {
        return price_per_night;
    }

    public void setPrice_per_night(String price_per_night) {
        this.price_per_night = price_per_night;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public Boolean getHasLinks() {
        return hasLinks;
    }

    public void setHasLinks(Boolean hasLinks) {
        this.hasLinks = hasLinks;
    }
}
