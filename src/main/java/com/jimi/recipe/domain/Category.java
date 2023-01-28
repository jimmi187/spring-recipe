package com.jimi.recipe.domain;

import jakarta.persistence.*;

import java.util.Set;
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    @ManyToMany(mappedBy = "categories")    // sa ove strane se setuje za recipes mapped by categories (atribut u Recipy)
    private Set<Recipe> recipes;            // da bi imali jedu zajednicu tabelu
}