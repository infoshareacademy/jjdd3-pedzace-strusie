package model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

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

    @Column(name = "isActive")
    private boolean isActive;

    @Column(name = "isDefault")
    private boolean isDefault;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Category() {
    }

    public Category(User user, String category) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Category{");
        sb.append("id=").append(id);
        sb.append(", category='").append(category).append('\'');
        sb.append(", isActive=").append(isActive);
        sb.append(", isDefault=").append(isDefault);
        sb.append(", user=").append(user);
        sb.append('}');
        return sb.toString();
    }
}
