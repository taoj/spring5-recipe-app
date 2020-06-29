package steven.springframework.recipe_app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

import steven.springframework.recipe_app.services.RecipeService;

@Slf4j
@Controller
public class RecipeController {

  private RecipeService recipeService;

  public RecipeController(RecipeService recipeService) {
    this.recipeService = recipeService;
  }

  @RequestMapping("recipe/list")
  public String getAllRecipes(Model model){
    log.info("this is in recipe controller.");
    model.addAttribute("recipes", recipeService.getRecipes());

    return "recipe/recipe_list";
  }
}
