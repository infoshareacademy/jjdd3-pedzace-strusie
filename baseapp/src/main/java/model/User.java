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

    @OneToMany(mappedBy = "user")
    private List<UsersLogins> logins;

    @OneToMany(mappedBy = "user")
    private Set<Income> income;

    @OneToMany(mappedBy = "user")
    private Set<Expense> expense;

    @ManyToMany
    @JoinTable(name = "user_to_category", joinColumns = @JoinColumn(name = "id_user_fk", referencedColumnName = "id"))
    private Set<Category> categories;

    @ManyToMany
    @JoinTable(name = "user_to_categoryPromoted", joinColumns = @JoinColumn(name = "id_user_fk", referencedColumnName = "id"))
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

    public List<UsersLogins> getLogins() {
        return logins;
    }

    public void setLogins(List<UsersLogins> logins) {
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
