package com.jimi.recipe.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private BigDecimal amount;

    @ManyToOne         // no cascade we don't wanna delete recipe if we delete ingredient
    private Recipe recipe;


}
