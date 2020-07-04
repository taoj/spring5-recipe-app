package steven.springframework.recipe_app.repositories;


import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import steven.springframework.recipe_app.models.UnitOfMeasure;


@RunWith(SpringRunner.class)
@DataJpaTest
class UnitOfMeasureRepoIT {

  @Autowired
  UnitOfMeasureRepo unitOfMeasureRepo;

  @BeforeEach
  void setUp() {
  }

  @Test
  void findByDescription() {
    Optional<UnitOfMeasure> measure = unitOfMeasureRepo.findByDescription("Pinch");

    assertEquals("Pinch", measure.get().getDescription());
  }
}
