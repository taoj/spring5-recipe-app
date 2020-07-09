package steven.springframework.recipe_app.commands;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import steven.springframework.recipe_app.models.Recipe.Difficulty;

@Getter
@Setter
@NoArgsConstructor
public class RecipeCommand {

  private Long id;
  private String description;
  private Integer prepTime;
  private Integer cookTime;
  private Integer servings;
  private String source;
  private String url;
  private String directions;
  private Set<IngredientCommand> ingredients = new HashSet<>();
  private Difficulty difficulty;
  private NotesCommand notes;
  private Set<CategoryCommand> categories = new HashSet<>();
}
