package svalbuena.springframework.sfgrecipes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import svalbuena.springframework.sfgrecipes.services.RecipeService;

@Controller
public class IndexController {
    private final RecipeService recipeService;

    public IndexController(final RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping({"", "/"})
    public String getIndexPage(final Model model) {
        model.addAttribute("recipes", recipeService.getAllRecipes());
        return "index";
    }
}
