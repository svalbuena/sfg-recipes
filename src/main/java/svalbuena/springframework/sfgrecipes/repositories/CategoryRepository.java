package svalbuena.springframework.sfgrecipes.repositories;

import org.springframework.data.repository.CrudRepository;
import svalbuena.springframework.sfgrecipes.domain.Category;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    Optional<Category> findByDescription(final String description);
}
