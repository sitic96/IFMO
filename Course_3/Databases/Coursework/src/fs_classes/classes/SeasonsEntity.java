package fs_classes.classes;

import javax.persistence.*;

/**
 * Created by sitora on 22.11.16.
 */
@Entity
@Table(name = "SEASONS", schema = "FS", catalog = "")
public class SeasonsEntity {
    private int id;
    private String season;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "SEASON", nullable = false, length = 15)
    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SeasonsEntity that = (SeasonsEntity) o;

        if (id != that.id) return false;
        if (season != null ? !season.equals(that.season) : that.season != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (season != null ? season.hashCode() : 0);
        return result;
    }
}
