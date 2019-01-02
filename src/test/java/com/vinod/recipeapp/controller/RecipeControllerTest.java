package com.vinod.recipeapp.controller;

import com.vinod.recipeapp.domain.Recipe;
import com.vinod.recipeapp.service.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.isNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class RecipeControllerTest {

    @Mock
    RecipeService recipeService;

    @InjectMocks
    RecipeController recipeController;

    MockMvc mockMvc;

    Set<Recipe> recipes;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

        recipes = new HashSet<>();
        recipes.add(new Recipe().builder().id(1L).build());
        recipes.add(new Recipe().builder().id(2L).build());

        mockMvc = MockMvcBuilders.standaloneSetup(recipeController).build();
    }

    @Test
    public void getRecipes() throws Exception {

        when(recipeService.getRecipes()).thenReturn(recipes);

        mockMvc.perform(get("/recipe/"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("recipes",hasSize(2)))
                .andExpect(view().name("index"));
    }

    @Test
    public void getRecipeById() throws Exception {

        Recipe dummyRecipe = Recipe.builder().id(1L).build();
        when(recipeService.getRecipeById(anyLong())).thenReturn(dummyRecipe);

        mockMvc.perform(get("/recipe/1"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("recipe",isNotNull()))
                .andExpect(view().name("recipe/show"));

    }
}