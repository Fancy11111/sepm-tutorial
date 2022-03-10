package at.spring.example.enums;

public enum Gender {
    MALE("MALE"),
    FEMALE("FEMALE");

    private String gender;

    Gender(String gender) {
        this.gender = gender;
    }
}
