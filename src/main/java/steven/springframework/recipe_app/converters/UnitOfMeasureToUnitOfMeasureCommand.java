package steven.springframework.recipe_app.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import lombok.Synchronized;

import steven.springframework.recipe_app.commands.UnitOfMeasureCommand;
import steven.springframework.recipe_app.models.UnitOfMeasure;

@Component
public class UnitOfMeasureToUnitOfMeasureCommand implements
    Converter<UnitOfMeasure, UnitOfMeasureCommand> {

  @Synchronized
  @Nullable
  @Override
  public UnitOfMeasureCommand convert(UnitOfMeasure unitOfMeasure) {

    if (unitOfMeasure != null) {
      final UnitOfMeasureCommand uomc = new UnitOfMeasureCommand();
      uomc.setId(unitOfMeasure.getId());
      uomc.setDescription(unitOfMeasure.getDescription());
      return uomc;
    }
    return null;
  }
}
