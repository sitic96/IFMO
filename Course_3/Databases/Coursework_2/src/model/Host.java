package model;

import java.util.HashMap;
import java.util.HashSet;

public class Host extends MongoObject {
    public Host() {
    }

    public static final HashSet<String> params;

    static {
        params = new HashSet<>();
        params.add("hostName");
        params.add("phoneNumber");
        params.add("hostPass");
    }

    private String id;

    private Boolean hasLinks;

    private String hostName;

    private String phoneNumber;

    private String hostPass;

    public Host(String hostName, String phoneNumber, String hostPass) {
        this.hostName = hostName;
        this.phoneNumber = phoneNumber;
        this.hostPass = hostPass;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() == 11 && phoneNumber.matches("[0-9]+")) {
            this.phoneNumber = phoneNumber;
        } else phoneNumber = null;
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

    public String getHostPass() {
        return hostPass;
    }

    public void setHostPass(String hostPass) {
        if (hostPass.length() == 10 && hostPass.matches("[0-9]+")) {
            this.hostPass = hostPass;
        } else hostPass = null;
    }

    public Boolean getHasLinks() {
        return hasLinks;
    }

    public void setHasLinks(Boolean hasLinks) {
        this.hasLinks = hasLinks;
    }
}