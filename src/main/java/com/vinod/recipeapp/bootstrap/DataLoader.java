package com.vinod.recipeapp.bootstrap;

import com.vinod.recipeapp.repository.CategoryRepository;
import com.vinod.recipeapp.repository.RecipeRepository;
import com.vinod.recipeapp.repository.UnitOfMeasureRepository;
import org.springframework.boot.CommandLineRunner;


public class DataLoader implements CommandLineRunner {


    private RecipeRepository recipeRepository;
    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public DataLoader(RecipeRepository recipeRepository, CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.recipeRepository = recipeRepository;
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        /*Set<Recipe> recipes = getRecipes();
        recipeRepository.saveAll(recipes);*/

    }

    /*private Set<Recipe> getRecipes() throws Exception {
        Set<Recipe> recipes = new HashSet<>();

        // Get Some Categories
        Optional<Category> mexicanOptional =  categoryRepository.findByDescription("Mexican");
        if (!mexicanOptional.isPresent()){
            throw new Exception("Expected Category not found");
        }
        Optional<Category> americanOptional =  categoryRepository.findByDescription("American");
        if (!americanOptional.isPresent()){
            throw new Exception("Expected Category not found");
        }
        Category american =  americanOptional.get();
        Category mexican =  mexicanOptional.get();

        // Get Some Units
        Optional<UnitOfMeasure> ripeOptional = unitOfMeasureRepository.findByName("Ripe");
        if (!ripeOptional.isPresent()) {
            throw new Exception("Expected UOM not found");
        }
        Optional<UnitOfMeasure> teaspoonOptional = unitOfMeasureRepository.findByName("Teaspoon");
        if (!teaspoonOptional.isPresent()) {
            throw new Exception("Expected UOM not found");
        }
        Optional<UnitOfMeasure> tablespoonOptional = unitOfMeasureRepository.findByName("Tablespoon");
        if (!tablespoonOptional.isPresent()) {
            throw new Exception("Expected UOM not found");
        }
        Optional<UnitOfMeasure> unitOptional = unitOfMeasureRepository.findByName("Unit");
        if (!unitOptional.isPresent()) {
            throw new Exception("Expected UOM not found");
        }
        Optional<UnitOfMeasure> dashOptional = unitOfMeasureRepository.findByName("Dash");
        if (!dashOptional.isPresent()) {
            throw new Exception("Expected UOM not found");
        }
        UnitOfMeasure ripe = ripeOptional.get();
        UnitOfMeasure teaspoon = teaspoonOptional.get();
        UnitOfMeasure tablespoon = tablespoonOptional.get();
        UnitOfMeasure unit = unitOptional.get();
        UnitOfMeasure dash = dashOptional.get();

        // Create Recipe 1
        Recipe guacamole = new Recipe();
        guacamole.setId(1L);
        guacamole.getCategories().add(mexican);
        guacamole.getCategories().add(american);
        guacamole.setPreTime(10);
        guacamole.setCookTime(10);
        guacamole.setServings(4);
        guacamole.setDescription("Guacamole, a dip made from avocados, is originally from Mexico. " +
                "The name is derived from two Aztec Nahuatl words—ahuacatl (avocado) and molli (sauce).");
        // Ingradients
        Set<Ingradient> ingradients = new HashSet<>();
        ingradients.add(new Ingradient("Avocados", BigDecimal.valueOf(2),ripe));
        ingradients.add(new Ingradient("Kosher Salt", BigDecimal.valueOf(1/2),teaspoon));
        ingradients.add(new Ingradient("Fresh Lime Juice or Lemon Juice", BigDecimal.valueOf(1),tablespoon));
        ingradients.add(new Ingradient("Minced red onion or Thinly sliced green onion", BigDecimal.valueOf(2),tablespoon));
        ingradients.add(new Ingradient("Serrano chiles, stems and seeds removed, minced", BigDecimal.valueOf(1),unit));
        ingradients.add(new Ingradient("Cilantro (leaves and tender stems), finely chopped", BigDecimal.valueOf(2),tablespoon));
        ingradients.add(new Ingradient("Freshly grated black pepper", BigDecimal.valueOf(1),dash));
        ingradients.add(new Ingradient("Tomato, Seeds and Pulp removed, chopped", BigDecimal.valueOf(1/2),ripe));
        guacamole.setIngredients(ingradients);

        guacamole.setDifficulty(Difficulty.MODERATE);
        Notes guacamoleNotes = new Notes();
        guacamoleNotes.setId(1L);
        guacamoleNotes.setRecipeNotes("Be careful handling chiles if using. Wash your hands thoroughly after handling " +
                "and do not touch your eyes or the area near your eyes with your hands for several hours.");
        //guacamoleNotes.setRecipe(guacamole);
        guacamole.setNotes(guacamoleNotes);
        guacamole.setSource("www.simplyrecipes.com");
        guacamole.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
        guacamole.setDirections("1. Cut avocado, remove flesh\n" +
                "2. Mash with a fork\n" +
                "3. Add salt, lime juice, and the rest\n" +
                "4. Cover with plastic and chill to store\n");

        recipes.add(guacamole);
        return recipes;
    }*/


}
