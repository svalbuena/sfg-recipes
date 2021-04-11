package svalbuena.springframework.sfgrecipes.services;

import svalbuena.springframework.sfgrecipes.domain.Recipe;

import java.util.Optional;
import java.util.Set;

public interface RecipeService {
    Optional<Recipe> getById(final Long id);
    Set<Recipe> getAllRecipes();
}
