package steven.springframework.recipe_app.models;

import static org.junit.jupiter.api.Assertions.*;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

class CategoryTest {


  Category category;
  @BeforeEach
  void setUp() {
    System.out.println("in before each.");
    category = new Category();
  }

  @Test
  void getId() {
    Long aLong = 4l;
    category.setId(aLong);
    assertEquals(aLong, category.getId());
  }

  @Test
  void test(){
    Assert.isTrue(true, "message");
  }
}
