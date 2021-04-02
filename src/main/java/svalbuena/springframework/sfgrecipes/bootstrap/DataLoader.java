package svalbuena.springframework.sfgrecipes.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import svalbuena.springframework.sfgrecipes.domain.Category;
import svalbuena.springframework.sfgrecipes.domain.Difficulty;
import svalbuena.springframework.sfgrecipes.domain.Ingredient;
import svalbuena.springframework.sfgrecipes.domain.Notes;
import svalbuena.springframework.sfgrecipes.domain.Recipe;
import svalbuena.springframework.sfgrecipes.domain.UnitOfMeasure;
import svalbuena.springframework.sfgrecipes.repositories.CategoryRepository;
import svalbuena.springframework.sfgrecipes.repositories.RecipeRepository;
import svalbuena.springframework.sfgrecipes.repositories.UnitOfMeasureRepository;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class DataLoader implements CommandLineRunner {
    private final RecipeRepository recipeRepository;
    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public DataLoader(final RecipeRepository recipeRepository,
                      final CategoryRepository categoryRepository,
                      final UnitOfMeasureRepository unitOfMeasureRepository) {
        this.recipeRepository = recipeRepository;
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void run(final String... args) {
        loadData();
    }

    private void loadData() {
        final List<Recipe> recipes = new ArrayList<>();
        recipes.add(createGuacamole());
        recipes.add(createTacos());
        recipeRepository.saveAll(recipes);
    }

    private Recipe createGuacamole() {
        final Recipe guacamole = new Recipe();
        guacamole.setDescription("Perfect Guacamole");
        guacamole.setServings(4);
        guacamole.getCategories().add(createCategory("Mexican"));
        guacamole.getCategories().add(createCategory("American"));
        guacamole.setDifficulty(Difficulty.EASY);
        guacamole.setPreparationTime(10);
        guacamole.setCookTime(0);
        guacamole.getIngredients().add(createIngredient(guacamole, "ripe avocado", 2, "piece"));
        guacamole.getIngredients().add(createIngredient(guacamole, "salt", 0.25, "teaspoon"));
        guacamole.getIngredients().add(createIngredient(guacamole, "fresh lime juice or lemon juice", 1, "tablespoon"));
        guacamole.getIngredients().add(createIngredient(guacamole, "serrano chiles, stems and seeds removed, minced", 1, "piece"));
        guacamole.getIngredients().add(createIngredient(guacamole, "cilantro (leaves and tender stems), finely chopped", 2, "tablespoon"));
        guacamole.getIngredients().add(createIngredient(guacamole, "freshly grated black pepper", 1, "dash"));
        guacamole.getIngredients().add(createIngredient(guacamole, "red radishes or jicama, to garnish", 1, "bunch"));
        guacamole.getIngredients().add(createIngredient(guacamole, "tortilla chips, to serve", 1, "bunch"));
        guacamole.setDirections(
                        "1 - Cut the avocado, remove flesh:\n" +
                        "Cut the avocados in half. Remove the pit. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl.\n" +
                        "\n" +
                        "2 - Mash with a fork:\n" +
                        "Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)\n" +
                        "\n" +
                        "3 - Add salt, lime juice, and the rest:\n" +
                        "Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                        "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
                        "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n" +
                        "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.\n" +
                        "\n" +
                        "4 - Serve:\n" +
                        "Serve immediately, or if making a few hours ahead, place plastic wrap on the surface of the guacamole and press down to cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.");
        guacamole.setImage(createImage("guacamole.webp"));
        guacamole.setNotes(createNotes(guacamole, "Be careful handling chiles if using. Wash your hands thoroughly after handling and do not touch your eyes or the area near your eyes with your hands for several hours."));
        guacamole.setSource("Simply Recipes");
        guacamole.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
        return guacamole;
    }

    private Recipe createTacos() {
        final Recipe tacos = new Recipe();
        tacos.setDescription("Spicy Grilled Chicken Tacos");
        tacos.setServings(6);
        tacos.getCategories().add(createCategory("Mexican"));
        tacos.getCategories().add(createCategory("American"));
        tacos.setDifficulty(Difficulty.MODERATE);
        tacos.setPreparationTime(20);
        tacos.setCookTime(15);
        tacos.getIngredients().add(createIngredient(tacos, "ancho chili powder", 2, "tablespoon"));
        tacos.getIngredients().add(createIngredient(tacos, "dried oregano", 1, "teaspoon"));
        tacos.getIngredients().add(createIngredient(tacos, "dried cumin ", 1, "teaspoon"));
        tacos.getIngredients().add(createIngredient(tacos, "sugar", 1, "teaspoon"));
        tacos.getIngredients().add(createIngredient(tacos, "salt", 0.5, "teaspoon"));
        tacos.getIngredients().add(createIngredient(tacos, "garlic, finely chopped", 1, "clove"));
        tacos.getIngredients().add(createIngredient(tacos, "finely grated orange zest", 1, "tablespoon"));
        tacos.getIngredients().add(createIngredient(tacos, "fresh-squeezed orange juice", 3, "tablespoon"));
        tacos.getIngredients().add(createIngredient(tacos, "olive oil", 2, "tablespoon"));
        tacos.getIngredients().add(createIngredient(tacos, "skinless, boneless chicken thighs", 6, "piece"));
        tacos.getIngredients().add(createIngredient(tacos, "small corn tortillas", 8, "piece"));
        tacos.getIngredients().add(createIngredient(tacos, "packed baby arugula", 3, "cup"));
        tacos.getIngredients().add(createIngredient(tacos, "medium ripe avocados, sliced", 2, "piece"));
        tacos.getIngredients().add(createIngredient(tacos, "radishes, thinly sliced", 4, "piece"));
        tacos.getIngredients().add(createIngredient(tacos, "cherry tomatoes, halved", 0.5, "pint"));
        tacos.getIngredients().add(createIngredient(tacos, "red onion, thinly sliced", 0.25, "piece"));
        tacos.getIngredients().add(createIngredient(tacos, "roughly chopped cilantro", 1, "bunch"));
        tacos.getIngredients().add(createIngredient(tacos, "cup sour cream", 0.5, "cup"));
        tacos.getIngredients().add(createIngredient(tacos, "lime, cut into wedges", 1, "piece"));
        tacos.setDirections(
                        "1 - Prepare a gas or charcoal grill for medium-high, direct heat\n" +
                        "\n" +
                        "2 - Make the marinade and coat the chicken:\n" +
                        "In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n" +
                        "Set aside to marinate while the grill heats and you prepare the rest of the toppings.\n" +
                        "\n" +
                        "3 - Grill the chicken:\n" +
                        "Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.\n" +
                        "\n" +
                        "4 - Warm the tortillas:\n" +
                        "Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n" +
                        "Wrap warmed tortillas in a tea towel to keep them warm until serving.\n" +
                        "\n" +
                        "5 - Assemble the tacos:\n" +
                        "Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges. ");
        tacos.setImage(createImage("tacos.webp"));
        tacos.setNotes(createNotes(tacos, "Look for ancho chile powder with the Mexican ingredients at your grocery store, on buy it online. (If you can't find ancho chili powder, you replace the ancho chili, the oregano, and the cumin with 2 1/2 tablespoons regular chili powder, though the flavor won't be quite the same.) "));
        tacos.setSource("Simply Recipes");
        tacos.setUrl("https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");
        return tacos;
    }

    private Category createCategory(final String description) {
        final Optional<Category> category = categoryRepository.findByDescription(description);
        if (category.isEmpty()) {
            throw new RuntimeException("No Category found on the Database for {" + description + "}");
        }
        return category.get();
    }

    private Ingredient createIngredient(final Recipe recipe,
                                        final String ingredientDescription,
                                        final double amount,
                                        final String unitOfMeasureDescription) {
        final Ingredient ingredient = new Ingredient();
        ingredient.setRecipe(recipe);
        ingredient.setDescription(ingredientDescription);
        ingredient.setAmount(BigDecimal.valueOf(amount));
        final Optional<UnitOfMeasure> unitOfMeasure = unitOfMeasureRepository.findByDescription(unitOfMeasureDescription);
        if (unitOfMeasure.isEmpty()) {
            throw new RuntimeException("No Unit of Measure found on the Database for {" + unitOfMeasureDescription + "}");
        }
        ingredient.setUnitOfMeasure(unitOfMeasure.get());
        return ingredient;
    }

    private Notes createNotes(final Recipe recipe, final String content) {
        final Notes notes = new Notes();
        notes.setRecipe(recipe);
        notes.setNotes(content);
        return notes;
    }

    private Byte[] createImage(final String imageFilename) {
        final InputStream inputStream = getClass().getClassLoader().getResourceAsStream("images/" + imageFilename);
        if (inputStream == null) {
            throw new RuntimeException("Image {" + imageFilename + "} not found");
        }
        try {
            final byte[] primitiveBytes = inputStream.readAllBytes();
            final Byte[] bytes = new Byte[primitiveBytes.length];
            Arrays.setAll(bytes, byteIndex -> primitiveBytes[byteIndex]);
            return bytes;
        } catch (final IOException exception) {
            throw new RuntimeException("Failed to read image {" + imageFilename + "}", exception);
        }
    }
}