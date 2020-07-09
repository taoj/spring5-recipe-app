package steven.springframework.recipe_app.services;

import java.util.Set;

import steven.springframework.recipe_app.commands.RecipeCommand;
import steven.springframework.recipe_app.models.Recipe;

public interface RecipeService {

  Set<Recipe> getRecipes();
  Recipe getById(Long id);
  RecipeCommand saveRecipeCommand(RecipeCommand command);
}
