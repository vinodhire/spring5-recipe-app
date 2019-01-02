package com.vinod.recipeapp.controller;

import com.vinod.recipeapp.domain.Recipe;
import com.vinod.recipeapp.service.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Slf4j
@Controller
@RequestMapping("/recipe")
public class RecipeController {

    private RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/")
    public String getRecipes (Model model){
        Set<Recipe> recipes = recipeService.getRecipes();
        model.addAttribute("recipes",recipes);
        return "index";
    }

    @RequestMapping("/{id}")
    public  String getRecipeById(@PathVariable("id") Long recipeId, Model model){
        Recipe recipe = recipeService.getRecipeById(recipeId);
        model.addAttribute("recipe",recipe);
        return "recipe/show";
    }
}
