package com.jimi.recipe.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
@Data
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    @Lob
    private String directions;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe") // mappedBy is target property of ingredient class
    private Set<Ingredient> ingredients = new HashSet<>();
    @Lob
    private Byte[] image;
    @Enumerated(value = EnumType.STRING)    // EnumType.ORDINAL is gonna save enums as 1,2,3,4... if add mew values in middle,
    private Difficulty difficulty;          // it not gonna shift it so its address new values as old ones
    @OneToOne(cascade = CascadeType.ALL)    // this set ownership to recipe
    private Notes notes;
    @ManyToMany
    @JoinTable(name = "recipe_category",
            joinColumns = @JoinColumn(name = "recipe_id"),  // kad ide sa ove strane
            inverseJoinColumns = @JoinColumn(name = "category_id")) // kad ide od druge strane
    private Set<Category> categories = new HashSet<>();



    public void setNotes(Notes notes) {

        this.notes = notes;
        notes.setRecipe(this);
    }

    public Recipe addIngredient(Ingredient ingredient){
        ingredient.setRecipe(this);
        this.ingredients.add(ingredient);
        return this;
    }


}
