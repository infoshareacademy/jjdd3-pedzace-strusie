package com.infoshareacademy.webapp.model;

import javax.persistence.*;
import java.util.Set;

//@Entity
//@Table(name = "CATEGORIES")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_category")
    private Long id;

    @Column(name = "category_set")
    private Set<String> categorySet;

    @JoinColumn(name = "id_user")
    private Set<User> user;


    public Category() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<String> getCategorySet() {
        return categorySet;
    }

    public void setCategorySet(Set<String> categorySet) {
        this.categorySet = categorySet;
    }

    public Set<User> getUser() {
        return user;
    }

    public void setUser(Set<User> user) {
        this.user = user;
    }
}
