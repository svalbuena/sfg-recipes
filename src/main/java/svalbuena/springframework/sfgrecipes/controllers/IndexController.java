package svalbuena.springframework.sfgrecipes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import svalbuena.springframework.sfgrecipes.domain.Recipe;
import svalbuena.springframework.sfgrecipes.services.RecipeService;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class IndexController {
    private final RecipeService recipeService;

    public IndexController(final RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping({"", "/"})
    public String getIndexPage(final Model model) {
        final List<Recipe> recipes = recipeService.getAllRecipes().stream()
                .sorted(Comparator.comparingLong(Recipe::getId))
                .collect(Collectors.toList());
        model.addAttribute("recipes", recipes);
        return "index";
    }
}
