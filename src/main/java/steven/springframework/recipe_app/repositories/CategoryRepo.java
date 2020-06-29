package steven.springframework.recipe_app.repositories;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

import steven.springframework.recipe_app.models.Category;

public interface CategoryRepo extends CrudRepository<Category, Long>{

  Optional<Category> findByDescription(String description);
}
