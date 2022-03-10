package at.spring.example.persistence.impl;

import at.spring.example.entity.Dog;
import at.spring.example.enums.Gender;
import at.spring.example.exception.PersistenceException;
import at.spring.example.persistence.DogDao;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;
import java.util.Objects;

@Repository
public class DogJdbcDao implements DogDao {
    private static final String TABLE_NAME = "dog";
    private static final String SQL_SELECT_ALL = "SELECT * FROM " + TABLE_NAME;
    private static final String SQL_INSERT = "insert into " + TABLE_NAME + "(name, description, birthdate, gender) values(?, ?, ?, ?)";

    private final JdbcTemplate jdbcTemplate;

    public DogJdbcDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Dog> getAll() {
        try {
            return jdbcTemplate.query(SQL_SELECT_ALL, this::mapRow);
        } catch (DataAccessException e) {
            throw new PersistenceException("Could not query all horses", e);
        }
    }

    @Override
    public Dog create(Dog entity) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(conn -> {
            PreparedStatement ps = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, entity.getName());
            if(entity.getDescription() != null) {
                ps.setString(2, entity.getDescription());
            }
            else {
                ps.setNull(2, Types.VARCHAR);
            }
            ps.setDate(3, Date.valueOf(entity.getBirthdate()));
            ps.setString(4, entity.getGender().toString());

            return ps;
        }, keyHolder);

        entity.setId(((Number) Objects.requireNonNull(keyHolder.getKeys()).get("id")).longValue());

        return entity;
    }

    private Dog mapRow(ResultSet result, int rownum) throws SQLException {
        Dog dog = new Dog();
        dog.setId(result.getLong("id"));
        dog.setName(result.getString("name"));
        dog.setDescription(result.getString("description"));
        dog.setBirthdate(result.getDate("birthdate").toLocalDate());
        dog.setGender(Gender.valueOf(result.getString("gender")));
        dog.setTrainerId(result.getLong("trainerId"));
        return dog;
    }
}
