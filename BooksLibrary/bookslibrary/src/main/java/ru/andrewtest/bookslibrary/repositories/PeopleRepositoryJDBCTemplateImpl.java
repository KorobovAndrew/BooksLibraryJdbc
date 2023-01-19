package ru.andrewtest.bookslibrary.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.andrewtest.bookslibrary.models.Person;

import java.util.List;

@Component
public class PeopleRepositoryJDBCTemplateImpl implements PeopleRepository {

    //language=SQL
    private static final String SQL_GET_ALL_PEOPLE = "select * from person";
    private final JdbcTemplate jdbcTemplatePerson;

    public PeopleRepositoryJDBCTemplateImpl(JdbcTemplate jdbcTemplatePerson) {
        this.jdbcTemplatePerson = jdbcTemplatePerson;
    }

    private final static RowMapper<Person> personRawMapper = (row, rowNum) -> {
        int id = row.getInt("id");
        String fullName = row.getString("fullName");
        Integer yearOfBirth = row.getInt("yearOfBirth");
        return new Person(id, fullName, yearOfBirth);
    };

    @Override
    public List<Person> findAll() {
        return jdbcTemplatePerson.query(SQL_GET_ALL_PEOPLE, personRawMapper);
    }
}
