package svalbuena.springframework.sfgrecipes.bootstrap;

import lombok.extern.slf4j.Slf4j;
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

import javax.transaction.Transactional;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
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

    @Transactional
    @Override
    public void run(final String... args) {
        loadData();
        log.info("Data loaded!");
    }

    private void loadData() {
        final List<Recipe> recipes = new ArrayList<>();
        recipes.add(createGuacamole());
        recipes.add(createTacos());
        recipeRepository.saveAll(recipes);
    }

    private Recipe createGuacamole() {
        final String description = "Perfect Guacamole";
        final int servings = 4;
        final int preparationTime = 10;
        final int cookTime = 0;
        final String source = "Simply Recipes";
        final String url = "https://www.simplyrecipes.com/recipes/perfect_guacamole/";
        final String directions =
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
                "Serve immediately, or if making a few hours ahead, place plastic wrap on the surface of the guacamole and press down to cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.";

        final Recipe guacamole = new Recipe(
                description,
                preparationTime,
                cookTime,
                servings,
                source,
                url,
                directions,
                Difficulty.EASY,
                createImage("guacamole.webp"),
                createNotes("Be careful handling chiles if using. Wash your hands thoroughly after handling and do not touch your eyes or the area near your eyes with your hands for several hours.")
        );
        guacamole
                .addCategory(createCategory("Mexican"))
                .addCategory(createCategory("American"));
        guacamole
                .addIngredient(createIngredient("ripe avocado", 2, "piece"))
                .addIngredient(createIngredient("salt", 0.25, "teaspoon"))
                .addIngredient(createIngredient("fresh lime juice or lemon juice", 1, "tablespoon"))
                .addIngredient(createIngredient("serrano chiles, stems and seeds removed, minced", 1, "piece"))
                .addIngredient(createIngredient("cilantro (leaves and tender stems), finely chopped", 2, "tablespoon"))
                .addIngredient(createIngredient("freshly grated black pepper", 1, "dash"))
                .addIngredient(createIngredient("red radishes or jicama, to garnish", 1, "bunch"))
                .addIngredient(createIngredient("tortilla chips, to serve", 1, "bunch"));
        return guacamole;
    }

    private Recipe createTacos() {
        final String description = "Spicy Grilled Chicken Tacos";
        final int servings = 6;
        final int preparationTime = 20;
        final int cookTime = 15;
        final String source = "Simply Recipes";
        final String url = "https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/";
        final String directions =
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
                "Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.";

        final Recipe tacos = new Recipe(
                description,
                preparationTime,
                cookTime,
                servings,
                source,
                url,
                directions,
                Difficulty.MODERATE,
                createImage("tacos.webp"),
                createNotes("Look for ancho chile powder with the Mexican ingredients at your grocery store, on buy it online. (If you can't find ancho chili powder, you replace the ancho chili, the oregano, and the cumin with 2 1/2 tablespoons regular chili powder, though the flavor won't be quite the same.)")
        );
        tacos
                .addCategory(createCategory("Mexican"))
                .addCategory(createCategory("American"));
        tacos
                .addIngredient(createIngredient("ancho chili powder", 2, "tablespoon"))
                .addIngredient(createIngredient("dried oregano", 1, "teaspoon"))
                .addIngredient(createIngredient("dried cumin ", 1, "teaspoon"))
                .addIngredient(createIngredient("sugar", 1, "teaspoon"))
                .addIngredient(createIngredient("salt", 0.5, "teaspoon"))
                .addIngredient(createIngredient("garlic, finely chopped", 1, "clove"))
                .addIngredient(createIngredient("finely grated orange zest", 1, "tablespoon"))
                .addIngredient(createIngredient("fresh-squeezed orange juice", 3, "tablespoon"))
                .addIngredient(createIngredient("olive oil", 2, "tablespoon"))
                .addIngredient(createIngredient("skinless, boneless chicken thighs", 6, "piece"))
                .addIngredient(createIngredient("small corn tortillas", 8, "piece"))
                .addIngredient(createIngredient("packed baby arugula", 3, "cup"))
                .addIngredient(createIngredient("medium ripe avocados, sliced", 2, "piece"))
                .addIngredient(createIngredient("radishes, thinly sliced", 4, "piece"))
                .addIngredient(createIngredient("cherry tomatoes, halved", 0.5, "pint"))
                .addIngredient(createIngredient("red onion, thinly sliced", 0.25, "piece"))
                .addIngredient(createIngredient("roughly chopped cilantro", 1, "bunch"))
                .addIngredient(createIngredient("cup sour cream", 0.5, "cup"))
                .addIngredient(createIngredient("lime, cut into wedges", 1, "piece"));
        return tacos;
    }

    private Category createCategory(final String description) {
        return categoryRepository.findByDescription(description)
                .orElseThrow(() -> new RuntimeException("No Category found on the Database for {" + description + "}"));
    }

    private UnitOfMeasure createUnitOfMeasure(final String description) {
        return unitOfMeasureRepository.findByDescription(description)
                .orElseThrow(() -> new RuntimeException("No Unit of Measure found on the Database for {" + description + "}"));
    }

    private Ingredient createIngredient(final String description,
                                        final double amount,
                                        final String unitOfMeasure) {
        return new Ingredient(description, BigDecimal.valueOf(amount), createUnitOfMeasure(unitOfMeasure));
    }

    private Notes createNotes(final String description) {
        return new Notes(description);
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
