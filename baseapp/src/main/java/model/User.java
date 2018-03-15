package model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "login")
    @NotNull
    private String login;

    @Column(name = "password")
    @NotNull
    private String password;

    @Column(name = "role")
    @NotNull
    private String role;

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

    public User(String name, String login, String password, String role, Set<Income> income, Set<Expense> expense, Set<Category> categories, Set<CategoryPromoted> categoriesPromoted) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.role = role;
        this.income = income;
        this.expense = expense;
        this.categories = categories;
        this.categoriesPromoted = categoriesPromoted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", login='").append(login).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", role='").append(role).append('\'');
        sb.append(", income=").append(income);
        sb.append(", expense=").append(expense);
        sb.append(", categories=").append(categories);
        sb.append(", categoriesPromoted=").append(categoriesPromoted);
        sb.append('}');
        return sb.toString();
    }
}
