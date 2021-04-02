package svalbuena.springframework.sfgrecipes.repositories;

import org.springframework.data.repository.CrudRepository;
import svalbuena.springframework.sfgrecipes.domain.UnitOfMeasure;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
    
}
