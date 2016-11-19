package fs_classes.classes;

import DBWorker.Factory;
import DBWorker.Table;
import fs_classes.DAO.PersonDAO;

import java.util.HashSet;

/**
 * Created by sitora on 07.11.16.
 */

public class Person extends Table {
    public final int COLUMN_COUNT = 4;
    public static HashSet<String> columns;

    static {
        columns = new HashSet<>();
//        columns.add("id");
        columns.add("name");
        columns.add("country");
        columns.add("category");
    }
    private Integer id;
    private String name;
    private Integer country;
    private Integer category;

    public Person() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCountry() {
        return country;
    }

    public void setCountry(Integer country) {
        this.country = country;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    @Override
    public PersonDAO getDAO() {
        return Factory.getInstance().getPersonDAO();
    }
}
