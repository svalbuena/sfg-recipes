package svalbuena.springframework.sfgrecipes.repositories;

import org.springframework.data.repository.CrudRepository;
import svalbuena.springframework.sfgrecipes.domain.UnitOfMeasure;

import java.util.Optional;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
    Optional<UnitOfMeasure> findByDescription(final String description);
}
