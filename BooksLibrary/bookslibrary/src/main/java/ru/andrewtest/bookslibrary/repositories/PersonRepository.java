package ru.andrewtest.bookslibrary.repositories;

import ru.andrewtest.bookslibrary.models.Person;

import java.util.List;

public interface PersonRepository {
    List<Person> findAll();

    void addPerson(String fullName, Integer yearOfBirth);

    Person findPersonById(int id);

    void updatePerson(int personId, String fullName, Integer yearOfBirth);

    void deletePerson(int personId);
}
