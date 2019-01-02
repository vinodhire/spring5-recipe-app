package com.vinod.recipeapp.converter;

import com.vinod.recipeapp.command.RecipeCommand;
import com.vinod.recipeapp.domain.Recipe;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe> {

    @Synchronized
    @Nullable
    @Override
    public Recipe convert(RecipeCommand source) {
        if (source == null) {
            return null;
        }
        Recipe recipe = new Recipe();
        recipe.setId(source.getId());
        recipe.setDescription(source.getDescription());
        recipe.setCookTime(source.getCookTime());
        recipe.setPreTime(source.getPreTime());
        recipe.setServings(source.getServings());
        recipe.setDifficulty(source.getDifficulty());
        recipe.setCategories(source.getCategories());
        recipe.setDirections(source.getDirections());
        recipe.setSource(source.getSource());
        recipe.setNotes(source.getNotes());
        recipe.setIngredients(source.getIngredients());
        recipe.setUrl(source.getUrl());
        return recipe;
    }

}
