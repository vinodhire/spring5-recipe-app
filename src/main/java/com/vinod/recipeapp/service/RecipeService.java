package com.vinod.recipeapp.service;

import com.vinod.recipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService  {

    Set<Recipe> getRecipes();

    Recipe getRecipeById(Long id);
}
