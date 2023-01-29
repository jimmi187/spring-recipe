package com.jimi.recipe.controllers;


import com.jimi.recipe.domain.Category;
import com.jimi.recipe.domain.UnitOfMeasure;
import com.jimi.recipe.repositories.CategoryRepository;
import com.jimi.recipe.repositories.UnitOfMeasureRepository;
import com.jimi.recipe.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    private final RecipeService recipeService;

    public IndexController(//CategoryRepository categoryRepository,
                           //UnitOfMeasureRepository unitOfMeasureRepository,
                           RecipeService recipeService) {
//        this.categoryRepository = categoryRepository;
//        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.recipeService = recipeService;
    }

    @RequestMapping({"","/","/index","index.html"})
    public String getIndexPage(Model model){
//        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
//        Optional<UnitOfMeasure> optionalUnitOfMeasure = unitOfMeasureRepository.findByDescription("Teaspoon");
//        System.out.println("Cat id is: " + categoryOptional.get().getId());
//        System.out.println("UOM id is: " + optionalUnitOfMeasure.get().getId());

        model.addAttribute("recipes", recipeService.getRecipes());

        return "index";


    }

}
