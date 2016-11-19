package fs_classes.classes;

import DBWorker.Factory;
import DBWorker.Table;
import fs_classes.DAO.CountryDAO;

/**
 * Created by sitora on 07.11.16.
 */
public class Country extends Table {
    private static final int COLUMN_COUNT = 2;
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
}
