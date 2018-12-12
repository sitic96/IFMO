package fs_classes.classes;

import javax.persistence.*;

/**
 * Created by sitora on 22.11.16.
 */
@Entity
@Table(name = "AGE_GROUPS", schema = "FS", catalog = "")
public class AgeGroupsEntity {
    private int id;
    private String ageGroup;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "AGE_GROUP", nullable = false, length = 50)
    public String getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AgeGroupsEntity that = (AgeGroupsEntity) o;

        if (id != that.id) return false;
        if (ageGroup != null ? !ageGroup.equals(that.ageGroup) : that.ageGroup != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (ageGroup != null ? ageGroup.hashCode() : 0);
        return result;
    }
}
