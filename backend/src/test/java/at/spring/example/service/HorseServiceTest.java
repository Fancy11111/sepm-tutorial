package at.spring.example.service;

import at.spring.example.dto.DogDto;
import at.spring.example.entity.Dog;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ActiveProfiles({"test", "datagen"}) // enable "test" spring profile during test execution in order to pick up configuration from application-test.yml
@SpringBootTest
public class HorseServiceTest {

  @Autowired
  DogService horseService;

  @Test
  public void getAllReturnsAllStoredHorses() {
    List<DogDto> horses = horseService.allDogs();
    assertThat(horses.size()).isEqualTo(1);
    assertThat(horses.get(0).id()).isEqualTo(-1);
    assertThat(horses.get(0).name()).isEqualTo("Wendy");
  }
}
