package model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

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

    @ManyToMany(mappedBy = "categories")
    private List<User> user;

    @Column(name = "isActive")
    private boolean isActive;

    @Column(name = "isDefault")
    private boolean isDefault;

    public Category() {
    }

    public Category(String category, List<User> user) {
        this.category = category;
        this.user = user;
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

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Category{");
        sb.append("id=").append(id);
        sb.append(", category='").append(category).append('\'');
        sb.append(", user=").append(user);
        sb.append(", isActive=").append(isActive);
        sb.append(", isDefault=").append(isDefault);
        sb.append('}');
        return sb.toString();
    }
}
