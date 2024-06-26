package com.jimi.recipe.commands;

import com.jimi.recipe.domain.Category;
import com.jimi.recipe.domain.Difficulty;
import com.jimi.recipe.domain.Ingredient;
import com.jimi.recipe.domain.Notes;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
public class RecipeCommand {

        private Long id;
        private String description;
        private Integer prepTime;
        private Integer cookTime;
        private Integer servings;
        private String source;
        private String url;
        private String directions;
        private Set<IngredientCommand> ingredients = new HashSet<>();
        private Byte[] image;
        private Difficulty difficulty;
        private NotesCommand notes;
        private Set<CategoryCommand> categories = new HashSet<>();

}
