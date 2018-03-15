package model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "CATEGORIES")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "category")
    @NotNull
    private String category;


    public Category() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Category{");
        sb.append("id=").append(id);
        sb.append(", category='").append(category).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
