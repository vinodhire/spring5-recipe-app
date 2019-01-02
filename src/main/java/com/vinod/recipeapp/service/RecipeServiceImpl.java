package com.vinod.recipeapp.service;

import com.vinod.recipeapp.domain.Recipe;
import com.vinod.recipeapp.repository.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    private RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipes() {
        log.debug("I'm in the Recipe Service !!");
        Set<Recipe> recipes = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipes::add);
        return recipes;
    }

    @Override
    public Recipe getRecipeById(Long id) {
        log.debug("Getting Recipe By Id");
        Optional<Recipe> recipeOptional =  recipeRepository.findById(id);
        if (!recipeOptional.isPresent()){
            throw new RuntimeException("Recipe with id="+id+" not found.");
        }
        return recipeOptional.get();
    }

}
