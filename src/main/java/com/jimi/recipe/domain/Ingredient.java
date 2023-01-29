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

    @OneToOne(fetch = FetchType.EAGER)  // uni directional relationship  fetch is gonna fetch it every time
    private UnitOfMeasure uom;

    public Ingredient(){}

    public Ingredient( String description, BigDecimal amount, UnitOfMeasure uom) {

        this.description = description;
        this.amount = amount;
        this.uom = uom;
    }

    public Ingredient( String description, BigDecimal amount, UnitOfMeasure uom,Recipe recipe ) {

        this.description = description;
        this.amount = amount;
        this.uom = uom;
        this.recipe = recipe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public UnitOfMeasure getUom() {
        return uom;
    }

    public void setUom(UnitOfMeasure uom) {
        this.uom = uom;
    }
}
