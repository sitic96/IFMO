package fs_classes.classes;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by sitora on 22.11.16.
 */
public class NewsPersonsEntityPK implements Serializable {
    private int personId;
    private int newsId;

    @Column(name = "PERSON_ID", nullable = false)
    @Id
    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    @Column(name = "NEWS_ID", nullable = false)
    @Id
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

        NewsPersonsEntityPK that = (NewsPersonsEntityPK) o;

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
