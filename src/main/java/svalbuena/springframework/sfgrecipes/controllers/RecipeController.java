package svalbuena.springframework.sfgrecipes.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import svalbuena.springframework.sfgrecipes.services.RecipeService;

@RequiredArgsConstructor
@Controller
public class RecipeController {
    private final RecipeService recipeService;

    @GetMapping("/recipe/show/{id}")
    public String getIndexPage(@PathVariable final String id, final Model model) {
        model.addAttribute("recipe", recipeService.getById(Long.valueOf(id)).get());
        return "recipe/show";
    }
}
