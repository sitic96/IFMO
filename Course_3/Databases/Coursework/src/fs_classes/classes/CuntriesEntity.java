package fs_classes.classes;

import DBWorker.*;
//import fs_classes.DAO.CountryDAO;

import javax.persistence.*;
import javax.persistence.Table;

/**
 * Created by sitora on 22.11.16.
 */
@Entity
@Table(name = "CUNTRIES", schema = "FS", catalog = "")
public class CuntriesEntity extends DBWorker.Table {
    private int id;
    private String country;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "COUNTRY", nullable = false, length = 40)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CuntriesEntity that = (CuntriesEntity) o;

        if (id != that.id) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }

//    @Override
//    public CountryDAO getDAO() {
//        return Factory.getInstance().getCountryDAO();
//    }
}
