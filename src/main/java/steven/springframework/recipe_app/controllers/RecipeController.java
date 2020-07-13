package steven.springframework.recipe_app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

import steven.springframework.recipe_app.commands.RecipeCommand;
import steven.springframework.recipe_app.models.Recipe;
import steven.springframework.recipe_app.services.RecipeService;

@Slf4j
@Controller
public class RecipeController {

  private final RecipeService recipeService;

  public RecipeController(RecipeService recipeService) {
    this.recipeService = recipeService;
  }

  @RequestMapping({"list",""})
  public String getAllRecipes(Model model){
    log.info("this is in recipe controller.");
    model.addAttribute("recipes", recipeService.getRecipes());

    return "recipe_list";
  }

  @RequestMapping("recipe/{id}/show")
  public String getById(@PathVariable String id, Model model){

    Recipe recipe = recipeService.getById(Long.valueOf(id));
    log.info(recipe.getDescription()+" "+recipe.getSource());

    model.addAttribute("recipe", recipe);
    return "recipe/show";
  }

  @RequestMapping("recipe/new")
  public String newRecipe(Model model){

    model.addAttribute("recipe", new RecipeCommand());
    return "recipe/recipeform";
  }

  @PostMapping("recipe")
  public String saveOrUpdate(@ModelAttribute RecipeCommand recipeCommand){
    RecipeCommand savedRecipeCommand = recipeService.saveRecipeCommand(recipeCommand);
    return "redirect:/recipe/" + savedRecipeCommand.getId()+"/show";
  }

  @RequestMapping("recipe/{id}/update")
  public String updateRecipe(@PathVariable String id, Model model){

    model.addAttribute("recipe", recipeService.findRecipeCommandById(Long.valueOf(id)));
    return "recipe/recipeform";

  }

}
