package steven.springframework.recipe_app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

import steven.springframework.recipe_app.models.Recipe;
import steven.springframework.recipe_app.services.RecipeService;

@Slf4j
@Controller
public class RecipeController {

  private final RecipeService recipeService;

  public RecipeController(RecipeService recipeService) {
    this.recipeService = recipeService;
  }

  @RequestMapping("list")
  public String getAllRecipes(Model model){
    log.info("this is in recipe controller.");
    model.addAttribute("recipes", recipeService.getRecipes());

    return "recipe_list";
  }

  @RequestMapping("recipe/show/{id}")
  public String getById(@PathVariable String id, Model model){

    Recipe recipe = recipeService.getById(Long.valueOf(id));
    log.info(recipe.getDescription()+" "+recipe.getSource());

    model.addAttribute("recipe", recipe);
    return "recipe/show";
  }
}
