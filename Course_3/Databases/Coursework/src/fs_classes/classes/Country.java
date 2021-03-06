package fs_classes.classes;

import DBWorker.Factory;
import DBWorker.Table;
import fs_classes.DAO.CountryDAO;

import java.util.HashSet;

/**
 * Created by sitora on 07.11.16.
 */
public class Country extends Table {
    private static final int COLUMN_COUNT = 2;

    public static HashSet<String> COLUMNS;

    static {
        COLUMNS = new HashSet<>();
        COLUMNS.add("name");
        COLUMNS.add("country");
        COLUMNS.add("category");
    }
    public Country() {
    }

    private Integer id;
    private String country;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public CountryDAO getDAO() {
        return Factory.getInstance().getCountryDAO();
    }

    public static HashSet<String> getCOLUMNS() {
        return COLUMNS;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", country='" + country + '\'' +
                '}';
    }
}
