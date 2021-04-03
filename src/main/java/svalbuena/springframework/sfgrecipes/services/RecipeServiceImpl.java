package svalbuena.springframework.sfgrecipes.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import svalbuena.springframework.sfgrecipes.domain.Recipe;
import svalbuena.springframework.sfgrecipes.repositories.RecipeRepository;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository recipeRepository;

    @Override
    public Set<Recipe> getAllRecipes() {
        final Iterable<Recipe> recipes = recipeRepository.findAll();
        return StreamSupport.stream(recipes.spliterator(), false)
                .collect(Collectors.toSet());
    }
}
