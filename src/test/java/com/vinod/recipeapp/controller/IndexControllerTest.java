package com.vinod.recipeapp.controller;

import com.vinod.recipeapp.domain.Recipe;
import com.vinod.recipeapp.service.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class IndexControllerTest {

    private IndexController indexController;

    @Mock
    private RecipeService recipeService;

    @Mock
    private Model model;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.indexController = new IndexController(recipeService);
    }

    @Test
    public void testMockMVC() {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
        try {
            mockMvc.perform(get("/"))
                    .andExpect(status().isOk())
                    .andExpect(view().name("index"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getIndexPage() {

        // Given
        Set<Recipe> recipes = new HashSet<>();
        recipes.add(new Recipe().builder().id(1L).build());
        recipes.add(new Recipe().builder().id(2L).build());
        System.out.println(recipes);
        // When
        when(recipeService.getRecipes()).thenReturn(recipes);

        ArgumentCaptor<Set> argumentCaptor = ArgumentCaptor.forClass(Set.class);

        // Then
        String indexView = indexController.getIndexPage(model);
        assertEquals("index", indexView);
        verify(recipeService, times(1)).getRecipes();
        verify(model, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());
        Set<Recipe> recipeSet = argumentCaptor.getValue();
        assertEquals(2, recipeSet.size());

    }
}