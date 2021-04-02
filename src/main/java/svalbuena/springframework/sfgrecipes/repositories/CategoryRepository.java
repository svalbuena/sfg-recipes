package svalbuena.springframework.sfgrecipes.repositories;

import org.springframework.data.repository.CrudRepository;
import svalbuena.springframework.sfgrecipes.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    
}
