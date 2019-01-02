package com.vinod.recipeapp.converter;

import com.vinod.recipeapp.command.IngredientCommand;
import com.vinod.recipeapp.domain.Ingradient;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class IngredientToIngredientCommand implements Converter<Ingradient, IngredientCommand> {

    @Synchronized
    @Nullable
    @Override
    public IngredientCommand convert(Ingradient source) {
        if (source == null ){
            return null;
        }
        IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setId(source.getId());
        ingredientCommand.setDescription(source.getDescription());
        ingredientCommand.setAmount(source.getAmount());
        ingredientCommand.setUnitOfMeasure(source.getUnitOfMeasure());
        ingredientCommand.setRecipe(source.getRecipe());
        return ingredientCommand;
    }
}
