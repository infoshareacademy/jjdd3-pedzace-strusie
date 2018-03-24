package model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "USERS", uniqueConstraints = @UniqueConstraint(columnNames = {"userId"}))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "userId")
    private String userId;

    @Column(name = "isAdmin")
    private boolean isAdmin;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<UserLogin> logins;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<Income> income;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<Expense> expense;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<Category> categories;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<CategoryPromoted> categoriesPromoted;

    public User() {
    }

    public User(String userId, boolean isAdmin) {
        this.userId = userId;
        this.isAdmin = isAdmin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public List<UserLogin> getLogins() {
        return logins;
    }

    public void setLogins(List<UserLogin> logins) {
        this.logins = logins;
    }

    public Set<Income> getIncome() {
        return income;
    }

    public void setIncome(Set<Income> income) {
        this.income = income;
    }

    public Set<Expense> getExpense() {
        return expense;
    }

    public void setExpense(Set<Expense> expense) {
        this.expense = expense;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Set<CategoryPromoted> getCategoriesPromoted() {
        return categoriesPromoted;
    }

    public void setCategoriesPromoted(Set<CategoryPromoted> categoriesPromoted) {
        this.categoriesPromoted = categoriesPromoted;
    }

}
