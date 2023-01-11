package ru.andrewtest.bookslibrary.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.andrewtest.bookslibrary.models.Person;

import java.util.List;

@Component
public class PeopleRepositoryJDBCTemplateImpl implements PeopleRepository {
    private final JdbcTemplate jdbcTemplate;

    //language=SQL
    private static final String SQL_GET_ALL_PEOPLE = "select * from person";

    public PeopleRepositoryJDBCTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final static RowMapper<Person> personRawMapper = (row, rawNum) -> {
        int id = row.getInt("id");
        String fullName = row.getString("fullName");
        Integer yearOfBirth = row.getInt("yearOfBirth");
        return new Person(id, fullName, yearOfBirth);
    };

    @Override
    public List<Person> findAll() {
        return jdbcTemplate.query(SQL_GET_ALL_PEOPLE, personRawMapper);
    }
}
