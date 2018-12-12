package fs_classes.classes;

import DBWorker.*;
import fs_classes.DAO.PersonDAO;

import javax.persistence.*;
import javax.persistence.Table;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by sitora on 22.11.16.
 */
@Entity
@Table(name = "Persons", schema = "FS", catalog = "")
public class PersonsEntity extends DBWorker.Table {

    public static final HashSet<String> COLUMNS;
    static {
        COLUMNS = new HashSet<>();
        COLUMNS.add("name");
        COLUMNS.add("category");
        COLUMNS.add("country");
    }
    private int id;
    private String name;
    private byte[] photo;
    private int category;
    private int country;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "photo", nullable = true)
    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    @Basic
    @Column(name = "category", nullable = false)
    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    @Basic
    @Column(name = "country", nullable = false)
    public int getCountry() {
        return country;
    }

    public void setCountry(int country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonsEntity that = (PersonsEntity) o;

        if (id != that.id) return false;
        if (category != that.category) return false;
        if (country != that.country) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (!Arrays.equals(photo, that.photo)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(photo);
        result = 31 * result + category;
        result = 31 * result + country;
        return result;
    }

//    @Override
//    public PersonDAO getDAO() {
//        return Factory.getInstance().getPersonDAO();
//    }
}
