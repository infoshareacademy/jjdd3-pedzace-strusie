package com.infoshareacademy.webapp.domain;

import com.infoshareacademy.baseapp.UserRepository;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "CATEGORIES")
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_category")
    private Integer id;

    @Column(name = "category_set")
    private Set<String> categorySet;

    @JoinColumn(name = "id_user")
    private Set<User> user;
