package at.spring.example.service;

import at.spring.example.dto.DogDto;

import java.util.List;

/**
 * Service for working with dogs.
 */
public interface DogService {
    /**
     * Lists all dogs stored in the system.
     * @return list of all stored dogs
     */
    List<DogDto> allDogs();

    /**
     * create a new dog in the system
     * @param dto dog to be created
     * @return created dog
     */
    DogDto create(DogDto dto);
}
