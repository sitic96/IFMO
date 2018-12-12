package fs_classes.classes;

import javax.persistence.*;

/**
 * Created by sitora on 22.11.16.
 */
@Entity
@Table(name = "NEWS_CATEGORIES", schema = "FS", catalog = "")
public class NewsCategoriesEntity {
    private int id;
    private String categoryName;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "CATEGORY_NAME", nullable = false, length = 50)
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NewsCategoriesEntity that = (NewsCategoriesEntity) o;

        if (id != that.id) return false;
        if (categoryName != null ? !categoryName.equals(that.categoryName) : that.categoryName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (categoryName != null ? categoryName.hashCode() : 0);
        return result;
    }
}
