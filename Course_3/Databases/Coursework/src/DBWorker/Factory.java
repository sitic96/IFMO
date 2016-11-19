package DBWorker;

import fs_classes.DAO.CountryDAO;
import fs_classes.DAO.PersonDAO;

/**
 * Created by sitora on 07.11.16.
 */
public class Factory {

    private static PersonDAO personDAO = null;
    private static CountryDAO countryDAO = null;
    private static Factory instance = null;

    public static synchronized Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

    public PersonDAO getPersonDAO() {
        if (personDAO == null) {
            personDAO = new PersonDAO();
        }
        return personDAO;
    }

    public CountryDAO getCountryDAO() {
        if (countryDAO == null) {
            countryDAO = new CountryDAO();
        }
        return countryDAO;
    }
}
