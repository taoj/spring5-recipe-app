package steven.springframework.recipe_app.services;

import steven.springframework.recipe_app.commands.RecipeCommand;
import steven.springframework.recipe_app.converters.RecipeCommandToRecipe;
import steven.springframework.recipe_app.converters.RecipeToRecipeCommand;
import steven.springframework.recipe_app.models.Recipe;
import steven.springframework.recipe_app.repositories.RecipeRepo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RecipeServiceIT {

  public static final String NEW_DESCRIPTION = "New Description";

  @Autowired
  RecipeService recipeService;

  @Autowired
  RecipeRepo recipeRepository;

  @Autowired
  RecipeCommandToRecipe recipeCommandToRecipe;

  @Autowired
  RecipeToRecipeCommand recipeToRecipeCommand;

  @Transactional
  @Test
  public void testSaveOfDescription() throws Exception {
    //given
    Iterable<Recipe> recipes = recipeRepository.findAll();
    Recipe testRecipe = recipes.iterator().next();
    RecipeCommand testRecipeCommand = recipeToRecipeCommand.convert(testRecipe);

    //when
    testRecipeCommand.setDescription(NEW_DESCRIPTION);
    RecipeCommand savedRecipeCommand = recipeService.saveRecipeCommand(testRecipeCommand);

    //then
    assertEquals(NEW_DESCRIPTION, savedRecipeCommand.getDescription());
    assertEquals(testRecipe.getId(), savedRecipeCommand.getId());
    assertEquals(testRecipe.getCategories().size(), savedRecipeCommand.getCategories().size());
    assertEquals(testRecipe.getIngredients().size(), savedRecipeCommand.getIngredients().size());
  }
}
