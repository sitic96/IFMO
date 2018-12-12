package fs_classes.classes;

import javax.persistence.*;

/**
 * Created by sitora on 22.11.16.
 */
@Entity
@Table(name = "NEWS", schema = "FS", catalog = "")
public class NewsEntity {
    private int id;
    private int author;
    private String text;
    private int newsCategory;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "AUTHOR", nullable = false)
    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    @Basic
    @Column(name = "TEXT", nullable = false, length = 1000)
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Basic
    @Column(name = "NEWS_CATEGORY", nullable = false)
    public int getNewsCategory() {
        return newsCategory;
    }

    public void setNewsCategory(int newsCategory) {
        this.newsCategory = newsCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NewsEntity that = (NewsEntity) o;

        if (id != that.id) return false;
        if (author != that.author) return false;
        if (newsCategory != that.newsCategory) return false;
        if (text != null ? !text.equals(that.text) : that.text != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + author;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + newsCategory;
        return result;
    }
}
