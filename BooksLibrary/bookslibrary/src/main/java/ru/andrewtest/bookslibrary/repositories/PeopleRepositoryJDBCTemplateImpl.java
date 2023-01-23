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
    //language=SQL
    private static final String SQL_ADD_PERSON = "insert into person(fullName, yearOfBirth) values (?, ?)";
    //language=SQL
    private static final String SQL_GET_PERSON_BY_ID = "select * from person where id = ?";
    //language=SQL
    private static final String SQL_UPDATE_PERSON = "update person set fullName = ?, yearOfBirth = ? where id = ?";

    //language=SQL
    private static final String SQL_DELETE_PERSON_BY_ID = "delete from person where id = ?";
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

    @Override
    public void addPerson(String fullName, Integer yearOfBirth) {
        jdbcTemplatePerson.update(SQL_ADD_PERSON, fullName, yearOfBirth);
    }

    @Override
    public Person findPersonById(int id) {
        return jdbcTemplatePerson.queryForObject(SQL_GET_PERSON_BY_ID, personRawMapper, id);
    }

    @Override
    public void editPerson(int personId, String fullName, Integer yearOfBirth) {
        jdbcTemplatePerson.update(SQL_UPDATE_PERSON, fullName, yearOfBirth, personId);
    }

    @Override
    public void deletePerson(int personId) {
        jdbcTemplatePerson.update(SQL_DELETE_PERSON_BY_ID, personId);
    }
}
