package model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by sitora on 28.11.16.
 */
public class Cat extends MongoObject implements Serializable {

    private String id;
    private Boolean hasLinks;
    private String catName;
    private String chipNumber;
    private String hostName;
    private String passNumber;
    private String favoriteMeal;
    private final static HashSet<String> params;
    public final static HashMap<String, String> foreign_keys;

    public Cat() {
    }

    static {
        foreign_keys = new HashMap<>();
        foreign_keys.put("hostName", "Host");
        params = new HashSet<>();
        params.add("catName");
        params.add("chipNumber");
        params.add("passNumber");
        params.add("favoriteMeal");
    }

    public Cat(String catName, String chipNumber, String hostName, String passNumber, String favoriteMeal) {
        this.catName = catName;
        this.chipNumber = chipNumber;
        this.hostName = hostName;
        this.passNumber = passNumber;
        this.favoriteMeal = favoriteMeal;
    }

    public HashMap<String, String> getForeign_keys() {
        return foreign_keys;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getChipNumber() {
        return chipNumber;
    }

    public void setChipNumber(String chipNumber) {
        this.chipNumber = chipNumber;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getPassNumber() {
        return passNumber;
    }

    public void setPassNumber(String passNumber) {
        this.passNumber = passNumber;
    }

    public String getFavoriteMeal() {
        return favoriteMeal;
    }

    public void setFavoriteMeal(String favoriteMeal) {
        this.favoriteMeal = favoriteMeal;
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
