package at.spring.example.dto;

import at.spring.example.enums.Gender;

import java.time.LocalDate;

/**
 * Class for Horse DTOs
 * Contains all common properties
 */
public record DogDto(Long id, String name, String description, LocalDate birthdate, Gender gender, Long trainerId) {

}
