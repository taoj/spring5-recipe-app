package steven.springframework.recipe_app.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import steven.springframework.recipe_app.models.Recipe;
import steven.springframework.recipe_app.repositories.RecipeRepo;

class RecipeServiceImpTest {

  @Mock
  RecipeRepo recipeRepo;

  RecipeService recipeService;

  @BeforeEach
  void setup(){
    MockitoAnnotations.initMocks(this);

    recipeService = new RecipeServiceImp(recipeRepo);
  }

  @Test
  void testGetRecipts() {
    Set<Recipe> dummySet = new HashSet<>();
    Recipe recipe1 = new Recipe();
    dummySet.add(recipe1);
    when(recipeRepo.findAll()).thenReturn(dummySet);

    Set<Recipe> recipes = recipeService.getRecipes();
    assertEquals(recipes.size(), 1);
  }
}
