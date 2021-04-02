package svalbuena.springframework.sfgrecipes.services;

import svalbuena.springframework.sfgrecipes.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getAllRecipes();
}
