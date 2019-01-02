package com.vinod.recipeapp.command;

import com.vinod.recipeapp.domain.Category;
import com.vinod.recipeapp.domain.Difficulty;
import com.vinod.recipeapp.domain.Ingradient;
import com.vinod.recipeapp.domain.Notes;
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
    private int preTime;
    private int cookTime;
    private int servings;
    private String source;
    private String url;
    private String directions;
    private Set<Ingradient> ingredients = new HashSet<>();
    private Difficulty difficulty;
    private Notes notes;
    private Set<Category> categories = new HashSet<>();
}
