CREATE TABLE IF NOT EXISTS dog
(
    id              BIGINT AUTO_INCREMENT PRIMARY KEY,
    name            VARCHAR(255) NOT NULL,
    description     VARCHAR(255) NULL,
    birthdate       DATE NOT NULL,
    gender          ENUM('MALE', 'FEMALE') not null,
    trainerId       bigint null
);