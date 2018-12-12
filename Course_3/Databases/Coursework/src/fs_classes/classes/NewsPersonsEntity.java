package fs_classes.classes;

import javax.persistence.*;

/**
 * Created by sitora on 22.11.16.
 */
@Entity
@Table(name = "NEWS_PERSONS", schema = "FS", catalog = "")
@IdClass(NewsPersonsEntityPK.class)
public class NewsPersonsEntity {
    private int personId;
    private int newsId;

    @Id
    @Column(name = "PERSON_ID", nullable = false)
    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    @Id
    @Column(name = "NEWS_ID", nullable = false)
    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NewsPersonsEntity that = (NewsPersonsEntity) o;

        if (personId != that.personId) return false;
        if (newsId != that.newsId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = personId;
        result = 31 * result + newsId;
        return result;
    }
}
