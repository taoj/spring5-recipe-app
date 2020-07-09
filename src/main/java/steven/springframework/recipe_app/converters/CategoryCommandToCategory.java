package steven.springframework.recipe_app.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import lombok.Synchronized;

import steven.springframework.recipe_app.commands.CategoryCommand;
import steven.springframework.recipe_app.models.Category;

@Component
public class CategoryCommandToCategory implements Converter<CategoryCommand, Category> {

  @Synchronized
  @Nullable
  @Override
  public Category convert(CategoryCommand source) {
    if (source == null) {
      return null;
    }

    final Category category = new Category();
    category.setId(source.getId());
    category.setDescription(source.getDescription());
    return category;
  }
}
