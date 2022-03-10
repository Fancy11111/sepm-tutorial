package at.spring.example.persistence;

import at.spring.example.entity.Dog;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ActiveProfiles({"test", "datagen"}) // enable "test" spring profile during test execution in order to pick up configuration from application-test.yml
@SpringBootTest
public class HorseDaoTest {

  @Autowired
  DogDao horseDao;

  @Test
  public void getAllReturnsAllStoredHorses() {
    List<Dog> horses = horseDao.getAll();
    assertThat(horses.size()).isEqualTo(1);
    assertThat(horses.get(0).getId()).isEqualTo(-1);
    assertThat(horses.get(0).getName()).isEqualTo("Wendy");
  }

  @Test
  public void createOne() {
    List<Dog> horses = horseDao.getAll();
    assertThat(horses.size()).isEqualTo(1);
    assertThat(horses.get(0).getId()).isEqualTo(-1);
    assertThat(horses.get(0).getName()).isEqualTo("Wendy");
  }
}
