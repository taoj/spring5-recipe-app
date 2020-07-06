package steven.springframework.recipe_app.services;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import steven.springframework.recipe_app.models.Recipe;
import steven.springframework.recipe_app.repositories.RecipeRepo;

@Service
public class RecipeServiceImp implements RecipeService{

  private final RecipeRepo recipeRepo;

  public RecipeServiceImp(RecipeRepo recipeRepo) {
    this.recipeRepo = recipeRepo;
  }

  @Override
  public Set<Recipe> getRecipes() {
    Set<Recipe> result = new HashSet<>();
    recipeRepo.findAll().iterator().forEachRemaining(result::add);
    return result;
  }

  @Override
  public Recipe getById(Long id) {
    Optional<Recipe> optionalRecipe = recipeRepo.findById(id);
    if(!optionalRecipe.isPresent()){
      throw new RuntimeException("Recipe with id "+id+" was not found!" );
    }

    return optionalRecipe.get();
  }
}
