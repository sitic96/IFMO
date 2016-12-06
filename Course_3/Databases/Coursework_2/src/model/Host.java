package model;

import java.util.HashMap;
import java.util.HashSet;

public class Host extends MongoObject {

    public static final HashSet<String> params;

    static {
        params = new HashSet<>();
        params.add("name");
        params.add("phone_number");
        params.add("pass_number");
    }

    private String id;

    private Boolean hasLinks;

    private String name;

    private String phone_number;

    private String pass_number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        if (phone_number.length() == 11 && phone_number.matches("[0-9]+")) {
            this.phone_number = phone_number;
        } else phone_number = null;
    }

    @Override
    public HashSet<String> getParams() {
        return params;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public HashMap<String, String> getForeign_keys() {
        return null;
    }

    public String getPass_number() {
        return pass_number;
    }

    public void setPass_number(String pass_number) {
        if (pass_number.length() == 10 && pass_number.matches("[0-9]+")) {
            this.pass_number = pass_number;
        } else pass_number = null;
    }

    public Boolean getHasLinks() {
        return hasLinks;
    }

    public void setHasLinks(Boolean hasLinks) {
        this.hasLinks = hasLinks;
    }
}