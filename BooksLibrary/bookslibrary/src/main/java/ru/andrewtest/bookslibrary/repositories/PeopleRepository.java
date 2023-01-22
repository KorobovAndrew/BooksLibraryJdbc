package ru.andrewtest.bookslibrary.repositories;

import ru.andrewtest.bookslibrary.models.Person;

import java.util.List;

public interface PeopleRepository {
    List<Person> findAll();

    void addPerson(String fullName, Integer yearOfBirth);

    Person getPersonById(int id);

    void editPerson(int personId, String fullName, Integer yearOfBirth);
}
