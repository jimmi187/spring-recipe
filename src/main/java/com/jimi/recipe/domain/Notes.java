package com.jimi.recipe.domain;

import jakarta.persistence.*;
import lombok.*;

@Data
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne                  // note here we didn't specify anything that means cascade is one directional
    private Recipe recipe;
    @Lob
    private String recipeNotes;


}
