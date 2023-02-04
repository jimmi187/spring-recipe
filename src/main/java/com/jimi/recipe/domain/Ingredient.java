package com.jimi.recipe.domain;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode(exclude = {"recipe"})
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
}
