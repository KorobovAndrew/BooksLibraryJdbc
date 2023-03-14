package ru.andrewtest.bookslibrary.services;

import ru.andrewtest.bookslibrary.forms.PersonDto1;
import ru.andrewtest.bookslibrary.forms.PersonDto2;
import ru.andrewtest.bookslibrary.models.Person;

import java.util.List;

public interface PersonService {

    List<Person> findAllPeople();

    void addPerson(String fullName, Integer yearOfBirth);

    Person findPersonById(int personId);

    PersonDto2 findPersonDto2ById(Integer personId);

    void updatePerson(int personId, String fullName, Integer yearOfBirth);

    void deletePerson(int personId);

    List<PersonDto1> findAllPersonDto1();
}
