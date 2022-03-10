package at.spring.example.persistence;

import at.spring.example.entity.Dog;

import java.util.List;

/**
 * Data Access Object for horses.
 * Implements access functionality to the application's persistent data store regarding horses.
 */
public interface DogDao {
    /**
     * Get all horses stored in the persistent data store.
     * @return a list of all stored horses
     */
    List<Dog> getAll();

    Dog create(Dog entity);
}
