package com.jimi.recipe.services;

import com.jimi.recipe.commands.RecipeCommand;
import com.jimi.recipe.domain.Recipe;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();
    Recipe findById(Long l);
    RecipeCommand findCommandById(Long id);
    RecipeCommand saveRecipeCommand(RecipeCommand command);
    void deleteById(Long idToDelete);
}
