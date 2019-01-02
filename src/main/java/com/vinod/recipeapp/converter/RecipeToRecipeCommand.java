package com.vinod.recipeapp.converter;

import com.vinod.recipeapp.command.RecipeCommand;
import com.vinod.recipeapp.domain.Recipe;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class RecipeToRecipeCommand implements Converter<Recipe, RecipeCommand> {

    @Synchronized
    @Nullable
    @Override
    public RecipeCommand convert(Recipe source) {
        if (source == null ){
            return null;
        }
        RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setId(source.getId());
        recipeCommand.setDescription(source.getDescription());
        recipeCommand.setCookTime(source.getCookTime());
        recipeCommand.setPreTime(source.getPreTime());
        recipeCommand.setServings(source.getServings());
        recipeCommand.setDifficulty(source.getDifficulty());
        recipeCommand.setCategories(source.getCategories());
        recipeCommand.setDirections(source.getDirections());
        recipeCommand.setSource(source.getSource());
        recipeCommand.setNotes(source.getNotes());
        recipeCommand.setIngredients(source.getIngredients());
        recipeCommand.setUrl(source.getUrl());
        return recipeCommand;
    }
}
