package com.jimi.recipe.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
@Data
@EqualsAndHashCode(exclude = {"recipes"})
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    @ManyToMany(mappedBy = "categories")    // sa ove strane se setuje za recipes mapped by categories (atribut u Recipy)
    private Set<Recipe> recipes;            // da bi imali jedu zajednicu tabelu

}