package ru.andrewtest.bookslibrary.services;

import ru.andrewtest.bookslibrary.models.Person;

import java.util.List;

public interface PersonService {

    List<Person> findAllPeople();

    void addPerson(String fullName, Integer yearOfBirth);

    Person findPersonById(int personId);

    void updatePerson(int personId, String fullName, Integer yearOfBirth);

    void deletePerson(int personId);
}
