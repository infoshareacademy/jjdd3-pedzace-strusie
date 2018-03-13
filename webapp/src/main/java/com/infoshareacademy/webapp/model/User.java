package com.infoshareacademy.webapp.model;

import com.infoshareacademy.baseapp.Expense;
import com.infoshareacademy.baseapp.Income;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "USER")
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

    @OneToMany
    @JoinColumn(name = "income")
    private Income income;

    @OneToMany
    @JoinColumn(name = "expence")
    private Expense expense;

    @ManyToMany
    @JoinTable(name = "user_to_category")
    private Set<Category> categories;

    @ManyToMany
    @JoinTable(name = "user_to_categoryPromoted")
    private Set<CategoryPromoted> categoryPromoteds;

    public User() {
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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", login='").append(login).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
