package steven.springframework.recipe_app.services;

import java.util.Set;

import steven.springframework.recipe_app.models.Recipe;

public interface RecipeService {

  Set<Recipe> getRecipes();
}