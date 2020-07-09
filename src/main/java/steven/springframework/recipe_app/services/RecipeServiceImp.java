package steven.springframework.recipe_app.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import lombok.extern.slf4j.Slf4j;

import steven.springframework.recipe_app.commands.RecipeCommand;
import steven.springframework.recipe_app.converters.RecipeCommandToRecipe;
import steven.springframework.recipe_app.converters.RecipeToRecipeCommand;
import steven.springframework.recipe_app.models.Recipe;
import steven.springframework.recipe_app.repositories.RecipeRepo;

@Slf4j
@Service
public class RecipeServiceImp implements RecipeService{

  private final RecipeRepo recipeRepo;
  private final RecipeCommandToRecipe recipeCommandToRecipe;
  private final RecipeToRecipeCommand recipeToRecipeCommand;

  public RecipeServiceImp(RecipeRepo recipeRepo,
      RecipeCommandToRecipe recipeCommandToRecipe,
      RecipeToRecipeCommand recipeToRecipeCommand) {
    this.recipeRepo = recipeRepo;
    this.recipeCommandToRecipe = recipeCommandToRecipe;
    this.recipeToRecipeCommand = recipeToRecipeCommand;
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

  @Override
  @Transactional
  public RecipeCommand saveRecipeCommand(RecipeCommand command) {
    Recipe detachedRecipe = recipeCommandToRecipe.convert(command);

    Recipe savedRecipe = recipeRepo.save(detachedRecipe);
    log.debug("Saved RecipeId:" + savedRecipe.getId());
    return recipeToRecipeCommand.convert(savedRecipe);
  }
}
