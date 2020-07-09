package steven.springframework.recipe_app.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import lombok.Synchronized;

import steven.springframework.recipe_app.commands.UnitOfMeasureCommand;
import steven.springframework.recipe_app.models.UnitOfMeasure;

@Component
public class UnitOfMeasureCommandToUnitOfMeasure implements
    Converter<UnitOfMeasureCommand, UnitOfMeasure> {

  @Synchronized
  @Nullable
  @Override
  public UnitOfMeasure convert(UnitOfMeasureCommand source) {
    if (source == null) {
      return null;
    }

    final UnitOfMeasure uom = new UnitOfMeasure();
    uom.setId(source.getId());
    uom.setDescription(source.getDescription());
    return uom;
  }
}
