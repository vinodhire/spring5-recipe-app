package com.vinod.recipeapp.converter;

import com.vinod.recipeapp.command.CategoryCommand;
import com.vinod.recipeapp.domain.Category;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class CategoryCommandToCategoryTest {

    CategoryCommandToCategory converter;
    private final Long CATEGORY_ID = 1L;
    private final String CATEGORY_DESCRIPTION = "Test Category";


    @Before
    public void setUp() throws Exception {
        converter = new CategoryCommandToCategory();
    }

    @Test
    public void testNullParameter() throws Exception{
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject(){
        assertNotNull(converter.convert(new CategoryCommand()));
    }

    @Test
    public void convert() {
        //
        CategoryCommand categoryCommand = new CategoryCommand();
        categoryCommand.setId(1L);
        categoryCommand.setDescription("Test Category");

        Category category = converter.convert(categoryCommand);

        assertNotNull(category);
        assertEquals(CATEGORY_ID,category.getId());
        assertEquals(CATEGORY_DESCRIPTION,category.getDescription());
    }
}