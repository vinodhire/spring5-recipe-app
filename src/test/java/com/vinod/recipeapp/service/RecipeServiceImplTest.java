package com.vinod.recipeapp.service;

import com.vinod.recipeapp.domain.Recipe;
import com.vinod.recipeapp.repository.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class RecipeServiceImplTest {

    private RecipeService recipeService;

    @Mock
    private RecipeRepository recipeRepository;

    private Long recipeId = 1L;

    @Before
    public void setUp() throws Exception {
        // Initialize Mockit
        MockitoAnnotations.initMocks(this);
        this.recipeService = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    public void getRecipes() {

        // Putting Some Recipes into Mockito
        Recipe recipe = new Recipe();
        Set<Recipe> recipeSet = new HashSet<>();
        recipeSet.add(recipe);
        when(recipeService.getRecipes()).thenReturn(recipeSet);

        Set<Recipe> recipes = this.recipeService.getRecipes();
        assertEquals(1, recipes.size());
        verify(recipeRepository,times(1)).findAll();
    }

    @Test
    public void getRecipeById(){

        // Given
        Recipe dummyRecipe = Recipe.builder().id(recipeId).build();

        // When - Then
        when(recipeRepository.findById(anyLong())).thenReturn(Optional.of(dummyRecipe));

        // Verify
        Recipe recipe = recipeService.getRecipeById(recipeId);
        assertNotNull(recipe);
        assertNotNull(recipe.getId());
        assertEquals(recipeId,recipe.getId());
        verify(recipeRepository,times(1)).findById(anyLong());
    }
}