package svalbuena.springframework.sfgrecipes.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import svalbuena.springframework.sfgrecipes.domain.Category;
import svalbuena.springframework.sfgrecipes.domain.Difficulty;
import svalbuena.springframework.sfgrecipes.domain.Ingredient;
import svalbuena.springframework.sfgrecipes.domain.Notes;
import svalbuena.springframework.sfgrecipes.domain.Recipe;
import svalbuena.springframework.sfgrecipes.domain.UnitOfMeasure;
import svalbuena.springframework.sfgrecipes.services.RecipeService;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.LIST;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class IndexControllerTest {
    @Mock
    private RecipeService recipeService;
    @Mock
    private Model model;

    private IndexController controller;

    @BeforeEach
    void setUp() {
        controller = new IndexController(recipeService);
    }

    @Test
    void recipesAreReturned() {
        final Set<Recipe> expectedRecipes = givenRecipes();
        when(recipeService.getAllRecipes())
                .thenReturn(expectedRecipes);

        final Model model = new ExtendedModelMap();
        controller.getIndexPage(model);

        assertThat(model.asMap()).containsKey("recipes");
        final List<Recipe> actualRecipes = (List<Recipe>) model.getAttribute("recipes");
        assertThat(actualRecipes).containsAll(expectedRecipes);
    }

    private Set<Recipe> givenRecipes() {
        final Set<Recipe> recipes = new HashSet<>();
        recipes.add(givenRecipe(0L));
        recipes.add(givenRecipe(1L));
        return recipes;
    }

    private Recipe givenRecipe(final Long id) {
        final Set<Ingredient> ingredients = new HashSet<>();
        ingredients.add(new Ingredient("INGREDIENT", BigDecimal.ONE, new UnitOfMeasure("MEASURE")));
        final Set<Category> categories = new HashSet<>();
        categories.add(new Category("CATEGORY"));
        return new Recipe(
                id,
                "DESCRIPTION_" + id,
                0,
                0,
                0,
                "SOURCE_" + id,
                "URL_" + id,
                "DIRECTIONS_" + id,
                Difficulty.EASY,
                ingredients,
                new Byte[0],
                new Notes(),
                categories
        );
    }
}