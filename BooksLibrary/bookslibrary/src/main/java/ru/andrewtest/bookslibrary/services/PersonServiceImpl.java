package ru.andrewtest.bookslibrary.services;

import org.springframework.stereotype.Component;
import ru.andrewtest.bookslibrary.factories.PersonDtoFactory;
import ru.andrewtest.bookslibrary.models.Person;
import ru.andrewtest.bookslibrary.repositories.PersonRepository;

import java.util.List;

@Component
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> findAllPeople() {
        List<Person> people = personRepository.findAll();
        return people;
    }

    @Override
    public void addPerson(String fullName, Integer yearOfBirth) {
        personRepository.addPerson(fullName, yearOfBirth);
    }

    @Override
    public Person findPersonById(int personId) {
        return personRepository.findPersonById(personId);
    }

    @Override
    public void updatePerson(int personId, String fullName, Integer yearOfBirth) {
        personRepository.updatePerson(personId, fullName, yearOfBirth);
    }

    @Override
    public void deletePerson(int personId) {
        personRepository.deletePerson(personId);
    }
}
