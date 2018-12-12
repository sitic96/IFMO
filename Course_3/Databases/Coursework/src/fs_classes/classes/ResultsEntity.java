package fs_classes.classes;

import javax.persistence.*;

/**
 * Created by sitora on 22.11.16.
 */
@Entity
@Table(name = "RESULTS", schema = "FS", catalog = "")
public class ResultsEntity {
    private int id;
    private int season;
    private int competitionName;
    private int competitionCategory;
    private int ageGroup;
    private int pointsSp;
    private int pointsLp;
    private int resultPoints;
    private int placeSp;
    private int placeLp;
    private int resultPlace;
    private int sportsmen;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "SEASON", nullable = false)
    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    @Basic
    @Column(name = "COMPETITION_NAME", nullable = false)
    public int getCompetitionName() {
        return competitionName;
    }

    public void setCompetitionName(int competitionName) {
        this.competitionName = competitionName;
    }

    @Basic
    @Column(name = "COMPETITION_CATEGORY", nullable = false)
    public int getCompetitionCategory() {
        return competitionCategory;
    }

    public void setCompetitionCategory(int competitionCategory) {
        this.competitionCategory = competitionCategory;
    }

    @Basic
    @Column(name = "AGE_GROUP", nullable = false)
    public int getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(int ageGroup) {
        this.ageGroup = ageGroup;
    }

    @Basic
    @Column(name = "POINTS_SP", nullable = false)
    public int getPointsSp() {
        return pointsSp;
    }

    public void setPointsSp(int pointsSp) {
        this.pointsSp = pointsSp;
    }

    @Basic
    @Column(name = "POINTS_LP", nullable = false)
    public int getPointsLp() {
        return pointsLp;
    }

    public void setPointsLp(int pointsLp) {
        this.pointsLp = pointsLp;
    }

    @Basic
    @Column(name = "RESULT_POINTS", nullable = false)
    public int getResultPoints() {
        return resultPoints;
    }

    public void setResultPoints(int resultPoints) {
        this.resultPoints = resultPoints;
    }

    @Basic
    @Column(name = "PLACE_SP", nullable = false)
    public int getPlaceSp() {
        return placeSp;
    }

    public void setPlaceSp(int placeSp) {
        this.placeSp = placeSp;
    }

    @Basic
    @Column(name = "PLACE_LP", nullable = false)
    public int getPlaceLp() {
        return placeLp;
    }

    public void setPlaceLp(int placeLp) {
        this.placeLp = placeLp;
    }

    @Basic
    @Column(name = "RESULT_PLACE", nullable = false)
    public int getResultPlace() {
        return resultPlace;
    }

    public void setResultPlace(int resultPlace) {
        this.resultPlace = resultPlace;
    }

    @Basic
    @Column(name = "SPORTSMEN", nullable = false)
    public int getSportsmen() {
        return sportsmen;
    }

    public void setSportsmen(int sportsmen) {
        this.sportsmen = sportsmen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResultsEntity that = (ResultsEntity) o;

        if (id != that.id) return false;
        if (season != that.season) return false;
        if (competitionName != that.competitionName) return false;
        if (competitionCategory != that.competitionCategory) return false;
        if (ageGroup != that.ageGroup) return false;
        if (pointsSp != that.pointsSp) return false;
        if (pointsLp != that.pointsLp) return false;
        if (resultPoints != that.resultPoints) return false;
        if (placeSp != that.placeSp) return false;
        if (placeLp != that.placeLp) return false;
        if (resultPlace != that.resultPlace) return false;
        if (sportsmen != that.sportsmen) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + season;
        result = 31 * result + competitionName;
        result = 31 * result + competitionCategory;
        result = 31 * result + ageGroup;
        result = 31 * result + pointsSp;
        result = 31 * result + pointsLp;
        result = 31 * result + resultPoints;
        result = 31 * result + placeSp;
        result = 31 * result + placeLp;
        result = 31 * result + resultPlace;
        result = 31 * result + sportsmen;
        return result;
    }
}
