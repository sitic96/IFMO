package model;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by sitora on 28.11.16.
 */
public class Cat extends MongoObject{

    private final static HashSet<String> params;

    public HashMap<String, String> getForeign_keys() {
        return foreign_keys;
    }

    public final static HashMap<String, String> foreign_keys;
    static {
        foreign_keys = new HashMap<>();
        foreign_keys.put("host_id", "Host");
        params = new HashSet<>();
        params.add("name");
        params.add("microchip_number");
        params.add("host_id");
        params.add("pass_number");
        params.add("favorite_meal_id");
    }
    private String id;
    private Boolean hasLinks;
    private String name;
    private String microchip_number;
    private String host_id;
    private String pass_number;
    private String favorite_meal_id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMicrochip_number() {
        return microchip_number;
    }

    public void setMicrochip_number(String microchip_number) {
        this.microchip_number = microchip_number;
    }

    public String getHost_id() {
        return host_id;
    }

    public void setHost_id(String host_id) {
        this.host_id = host_id;
    }

    public String getPass_number() {
        return pass_number;
    }

    public void setPass_number(String pass_number) {
        this.pass_number = pass_number;
    }

    public String getFavorite_meal_id() {
        return favorite_meal_id;
    }

    public void setFavorite_meal_id(String favorite_meal_id) {
        this.favorite_meal_id = favorite_meal_id;
    }

    @Override
    public HashSet<String> getParams() {
        return params;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public Boolean getHasLinks() {
        return hasLinks;
    }

    public void setHasLinks(Boolean hasLinks) {
        this.hasLinks = hasLinks;
    }
}
