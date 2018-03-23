package model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

@Entity
@Table(name = "CATEGORIES", uniqueConstraints = @UniqueConstraint(columnNames = {"category"}))
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "category")
    @NotNull
    private String category;

    @ManyToMany(mappedBy = "categories", fetch = FetchType.EAGER)
    private Set<User> user;

    @Column(name = "isActive")
    private boolean isActive;

    @Column(name = "isDefault")
    private boolean isDefault;

    public Category() {
    }

    public Category(String category, Set<User> user) {
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

    public Set<User> getUser() {
        return user;
    }

    public void setUser(Set<User> user) {
        this.user = user;
    }

    public void addUserToSet(User user) {
        if (this.user == null) {
            this.user = new HashSet<>();
        }
        this.user.add(user);
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
