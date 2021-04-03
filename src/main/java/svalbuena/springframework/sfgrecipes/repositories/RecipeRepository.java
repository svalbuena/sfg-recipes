package svalbuena.springframework.sfgrecipes.repositories;

import org.springframework.data.repository.CrudRepository;
import svalbuena.springframework.sfgrecipes.domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {}
