package steven.springframework.recipe_app.repositories;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

import steven.springframework.recipe_app.models.UnitOfMeasure;

public interface UnitOfMeasureRepo extends CrudRepository<UnitOfMeasure, Long> {

  Optional<UnitOfMeasure> findByDescription(String description);
}
