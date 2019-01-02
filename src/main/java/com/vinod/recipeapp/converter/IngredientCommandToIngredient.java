package com.vinod.recipeapp.converter;

import com.vinod.recipeapp.command.IngredientCommand;
import com.vinod.recipeapp.domain.Ingradient;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingradient> {

    @Synchronized
    @Nullable
    @Override
    public Ingradient convert(IngredientCommand source) {
        if (source == null ) {
            return null;
        }
        Ingradient ingradient = new Ingradient();
        ingradient.setId(source.getId());
        ingradient.setDescription(source.getDescription());
        ingradient.setAmount(source.getAmount());
        ingradient.setUnitOfMeasure(source.getUnitOfMeasure());
        ingradient.setRecipe(source.getRecipe());
        return ingradient;
    }

}
