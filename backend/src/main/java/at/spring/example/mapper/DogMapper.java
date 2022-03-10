package at.spring.example.mapper;

import at.spring.example.dto.DogDto;
import at.spring.example.entity.Dog;
import at.spring.example.enums.Gender;
import org.springframework.stereotype.Component;

@Component
public class DogMapper {

    public DogDto entityToDto(Dog dog) {
        return new DogDto(dog.getId(), dog.getName(), dog.getDescription(), dog.getBirthdate(), dog.getGender(), dog.getTrainerId());
    }

    public Dog dtoToEntity(DogDto dto) {
        Dog dog = new Dog();
        dog.setId(dto.id());
        dog.setName(dto.name());
        dog.setDescription(dto.description());
        dog.setBirthdate(dto.birthdate());
        dog.setGender(dto.gender());
        dog.setTrainerId(dto.trainerId());
        return dog;
    }
}
