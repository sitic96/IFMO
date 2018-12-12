package fs_classes.classes;

import javax.persistence.*;

/**
 * Created by sitora on 22.11.16.
 */
@Entity
@Table(name = "COMPETITIONS_NAMES", schema = "FS", catalog = "")
public class CompetitionsNamesEntity {
    private int id;
    private String competitionName;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "COMPETITION_NAME", nullable = false, length = 50)
    public String getCompetitionName() {
        return competitionName;
    }

    public void setCompetitionName(String competitionName) {
        this.competitionName = competitionName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CompetitionsNamesEntity that = (CompetitionsNamesEntity) o;

        if (id != that.id) return false;
        if (competitionName != null ? !competitionName.equals(that.competitionName) : that.competitionName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (competitionName != null ? competitionName.hashCode() : 0);
        return result;
    }
}
