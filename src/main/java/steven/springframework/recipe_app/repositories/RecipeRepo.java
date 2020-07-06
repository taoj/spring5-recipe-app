package steven.springframework.recipe_app.repositories;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

import steven.springframework.recipe_app.models.Recipe;

public interface RecipeRepo extends CrudRepository<Recipe, Long> {

  Optional<Recipe> findByDescription(String description);
  Optional<Recipe> findById(Long id);
}
