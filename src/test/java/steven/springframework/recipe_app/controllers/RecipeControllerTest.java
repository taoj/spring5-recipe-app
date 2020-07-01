package steven.springframework.recipe_app.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import steven.springframework.recipe_app.models.Recipe;
import steven.springframework.recipe_app.services.RecipeService;

class RecipeControllerTest {

  @Mock
  RecipeService recipeService;
  @Mock
  Model model;

  RecipeController recipeController;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
    recipeController = new RecipeController(recipeService);
  }

  @Test
  void testGetAllRecipes(){

    Set<Recipe> recipes = new HashSet<>();

    recipes.add(new Recipe());
    Recipe recipe = new Recipe();
    recipe.setId(2L);
    recipes.add(recipe);

    ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

    when(recipeService.getRecipes()).thenReturn(recipes);


    assertEquals("recipe/recipe_list", recipeController.getAllRecipes(model));
    verify(model, times(1)).addAttribute(eq("recipes"),argumentCaptor.capture());
    Set<Recipe> setUsed = argumentCaptor.getValue();
    assertEquals(2, setUsed.size());
  }
}
