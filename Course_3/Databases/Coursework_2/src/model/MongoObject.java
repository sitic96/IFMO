package model;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by sitora on 27.11.16.
 */
public abstract class MongoObject {

    public abstract HashSet<String> getParams();

    private String id;

    public abstract String getId();

    public abstract void setId(String id);

    public abstract HashMap<String, String> getForeign_keys();
}