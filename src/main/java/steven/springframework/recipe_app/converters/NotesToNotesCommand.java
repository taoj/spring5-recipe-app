package steven.springframework.recipe_app.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import lombok.Synchronized;

import steven.springframework.recipe_app.commands.NotesCommand;
import steven.springframework.recipe_app.models.Notes;

@Component
public class NotesToNotesCommand implements Converter<Notes, NotesCommand> {

  @Synchronized
  @Nullable
  @Override
  public NotesCommand convert(Notes source) {
    if (source == null) {
      return null;
    }

    final NotesCommand notesCommand = new NotesCommand();
    notesCommand.setId(source.getId());
    notesCommand.setRecipeNotes(source.getRecipeNotes());
    return notesCommand;
  }
}

