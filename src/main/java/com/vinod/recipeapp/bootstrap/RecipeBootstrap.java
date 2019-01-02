package com.vinod.recipeapp.bootstrap;

import com.vinod.recipeapp.domain.*;
import com.vinod.recipeapp.repository.CategoryRepository;
import com.vinod.recipeapp.repository.RecipeRepository;
import com.vinod.recipeapp.repository.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private RecipeRepository recipeRepository;
    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public RecipeBootstrap(RecipeRepository recipeRepository, CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.recipeRepository = recipeRepository;
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Transactional
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Set<Recipe> recipes = getRecipes();
        log.debug(String.format("Got %s recipes",recipes.size()));
        List<Recipe> recipes1 = (List<Recipe>) recipeRepository.saveAll(recipes);
        log.debug("Recipe saved"+recipes1.size());
    }

    private Set<Recipe> getRecipes() {
        Set<Recipe> recipes = new HashSet<>();

        // Get Some Categories
        Optional<Category> mexicanOptional = categoryRepository.findByDescription("Mexican");
        if (!mexicanOptional.isPresent()) {
            throw new RuntimeException("Expected Category not found");
        }
        Optional<Category> americanOptional = categoryRepository.findByDescription("American");
        if (!americanOptional.isPresent()) {
            throw new RuntimeException("Expected Category not found");
        }
        Category american = americanOptional.get();
        Category mexican = mexicanOptional.get();

        // Get Some Units
        Optional<UnitOfMeasure> ripeOptional = unitOfMeasureRepository.findByName("Ripe");
        if (!ripeOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not found");
        }
        Optional<UnitOfMeasure> teaspoonOptional = unitOfMeasureRepository.findByName("Teaspoon");
        if (!teaspoonOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not found");
        }
        Optional<UnitOfMeasure> tablespoonOptional = unitOfMeasureRepository.findByName("Tablespoon");
        if (!tablespoonOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not found");
        }
        Optional<UnitOfMeasure> unitOptional = unitOfMeasureRepository.findByName("Unit");
        if (!unitOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not found");
        }
        Optional<UnitOfMeasure> dashOptional = unitOfMeasureRepository.findByName("Dash");
        if (!dashOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not found");
        }
        Optional<UnitOfMeasure> cupOptional = unitOfMeasureRepository.findByName("Cup");
        if (!cupOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not found");
        }
        Optional<UnitOfMeasure> pintOptional = unitOfMeasureRepository.findByName("Pint");
        if (!pintOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not found");
        }
        UnitOfMeasure ripe = ripeOptional.get();
        UnitOfMeasure teaspoon = teaspoonOptional.get();
        UnitOfMeasure tablespoon = tablespoonOptional.get();
        UnitOfMeasure unit = unitOptional.get();
        UnitOfMeasure dash = dashOptional.get();
        UnitOfMeasure cup = cupOptional.get();
        UnitOfMeasure pint = pintOptional.get();

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
        guacamole.addIngredient(new Ingradient("Avocados", BigDecimal.valueOf(2), ripe,guacamole));
        guacamole.addIngredient(new Ingradient("Kosher Salt", BigDecimal.valueOf(1 / 2), teaspoon,guacamole));
        guacamole.addIngredient(new Ingradient("Fresh Lime Juice or Lemon Juice", BigDecimal.valueOf(1), tablespoon,guacamole));
        guacamole.addIngredient(new Ingradient("Minced red onion or Thinly sliced green onion", BigDecimal.valueOf(2), tablespoon,guacamole));
        guacamole.addIngredient(new Ingradient("Serrano chiles, stems and seeds removed, minced", BigDecimal.valueOf(1), unit,guacamole));
        guacamole.addIngredient(new Ingradient("Cilantro (leaves and tender stems), finely chopped", BigDecimal.valueOf(2), tablespoon,guacamole));
        guacamole.addIngredient(new Ingradient("Freshly grated black pepper", BigDecimal.valueOf(1), dash,guacamole));
        guacamole.addIngredient(new Ingradient("Tomato, Seeds and Pulp removed, chopped", BigDecimal.valueOf(1 / 2), ripe,guacamole));

        guacamole.setDifficulty(Difficulty.MODERATE);
        Notes guacamoleNotes = new Notes();
        guacamoleNotes.setRecipeNotes("Be careful handling chiles if using. Wash your hands thoroughly after handling " +
                "and do not touch your eyes or the area near your eyes with your hands for several hours.");
        guacamole.setNotes(guacamoleNotes);
        guacamole.setSource("www.simplyrecipes.com");
        guacamole.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
        guacamole.setDirections("1. Cut avocado, remove flesh\n" +
                "2. Mash with a fork\n" +
                "3. Add salt, lime juice, and the rest\n" +
                "4. Cover with plastic and chill to store\n");

        // Tacos
        Recipe chickenTacos = new Recipe();
        chickenTacos.setId(2L);
        chickenTacos.getCategories().add(mexican);
        chickenTacos.setPreTime(20);
        chickenTacos.setCookTime(20);
        chickenTacos.setServings(6);
        chickenTacos.setDescription("Spicy Grilled Chicken Tacos");
        chickenTacos.setDifficulty(Difficulty.MODERATE);
        Notes chickenTacosNotes = new Notes();
        chickenTacosNotes.setRecipeNotes("Look for ancho chile powder with the Mexican ingredients at your grocery store, " +
                "on buy it online. (If you can't find ancho chili powder, you replace the ancho chili, the oregano, " +
                "and the cumin with 2 1/2 tablespoons regular chili powder, though the flavor won't be quite the same.)");
        chickenTacos.setNotes(chickenTacosNotes);
        chickenTacos.setDirections("1. Prepare a gas or charcoal grill for medium-high, direct heat.\n" +
                "2. Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n" +
                "Set aside to marinate while the grill heats and you prepare the rest of the toppings." +
                "3. Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.\n" +
                "4. 4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n" +
                "Wrap warmed tortillas in a tea towel to keep them warm until serving.\n" +
                "5. Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.");
        chickenTacos.setUrl("https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");
        chickenTacos.setSource("www.simplyrecipes.com");
        // Ingredients
        chickenTacos.addIngredient(new Ingradient("ancho chili powder",BigDecimal.valueOf(2),tablespoon,chickenTacos));
        chickenTacos.addIngredient(new Ingradient("dried oregano",BigDecimal.valueOf(1),teaspoon,chickenTacos));
        chickenTacos.addIngredient(new Ingradient("dried cumin",BigDecimal.valueOf(1),teaspoon,chickenTacos));
        chickenTacos.addIngredient(new Ingradient("sugar",BigDecimal.valueOf(1),teaspoon,chickenTacos));
        chickenTacos.addIngredient(new Ingradient("salt",BigDecimal.valueOf(1/2),teaspoon,chickenTacos));
        chickenTacos.addIngredient(new Ingradient("clove garlic, finely chopped",BigDecimal.valueOf(1),unit,chickenTacos));
        chickenTacos.addIngredient(new Ingradient("clove garlic, finely chopped",BigDecimal.valueOf(1),unit,chickenTacos));
        chickenTacos.addIngredient(new Ingradient("clove garlic, finely chopped",BigDecimal.valueOf(1),unit,chickenTacos));
        chickenTacos.addIngredient(new Ingradient("finely grated orange zest",BigDecimal.valueOf(1),tablespoon,chickenTacos));
        chickenTacos.addIngredient(new Ingradient("fresh-squeezed orange juice",BigDecimal.valueOf(3),tablespoon,chickenTacos));
        chickenTacos.addIngredient(new Ingradient("olive oil",BigDecimal.valueOf(2),tablespoon,chickenTacos));
        chickenTacos.addIngredient(new Ingradient("skinless, boneless chicken thighs (1 1/4 pounds)",BigDecimal.valueOf(6),unit,chickenTacos));
        chickenTacos.addIngredient(new Ingradient("small corn tortillas",BigDecimal.valueOf(8),unit,chickenTacos));
        chickenTacos.addIngredient(new Ingradient("cups packed baby arugula (3 ounces)",BigDecimal.valueOf(3),cup,chickenTacos));
        chickenTacos.addIngredient(new Ingradient("medium ripe avocados, sliced",BigDecimal.valueOf(2),unit,chickenTacos));
        chickenTacos.addIngredient(new Ingradient("radishes, thinly sliced)",BigDecimal.valueOf(4),unit,chickenTacos));
        chickenTacos.addIngredient(new Ingradient("cherry tomatoes, halved",BigDecimal.valueOf(1/2),pint,chickenTacos));
        chickenTacos.addIngredient(new Ingradient("red onion, thinly sliced",BigDecimal.valueOf(1/4),unit,chickenTacos));
        chickenTacos.addIngredient(new Ingradient("Roughly chopped cilantro",BigDecimal.valueOf(1),unit,chickenTacos));
        chickenTacos.addIngredient(new Ingradient("sour cream thinned with 1/4 cup milk",BigDecimal.valueOf(6),cup,chickenTacos));
        chickenTacos.addIngredient(new Ingradient("sour cream thinned with 1/4 cup milk",BigDecimal.valueOf(1/2),cup,chickenTacos));
        chickenTacos.addIngredient(new Ingradient("lime, cut into wedges",BigDecimal.valueOf(1),unit,chickenTacos));

        //chickenTacos.ad
        recipes.add(chickenTacos);
        recipes.add(guacamole);
        return recipes;
    }
}
