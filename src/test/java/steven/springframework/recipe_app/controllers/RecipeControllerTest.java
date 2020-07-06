package steven.springframework.recipe_app.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import steven.springframework.recipe_app.models.Recipe;
import steven.springframework.recipe_app.services.RecipeService;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

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
  void testMockMVC() throws Exception {
    MockMvc mockMvc = MockMvcBuilders.standaloneSetup(recipeController).build();
    mockMvc.perform(get("/list"))
        .andExpect(status().isOk())
        .andExpect(view().name("recipe_list"));

    mockMvc.perform(get("/recipe/show/1")).andExpect(status().isOk())
        .andExpect(view().name("recipe/show"));
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


    assertEquals("recipe_list", recipeController.getAllRecipes(model));
    verify(model, times(1)).addAttribute(eq("recipes"),argumentCaptor.capture());
    Set<Recipe> setUsed = argumentCaptor.getValue();
    assertEquals(2, setUsed.size());
  }

  @Test
  void testGetById(){
    Recipe recipe = new Recipe();
    Long id = 1L;
    when(recipeService.getById(id)).thenReturn(recipe);

    assertEquals("recipe/show", recipeController.getById("1", model));
    verify(recipeService, times(1)).getById(id);
  }


}
