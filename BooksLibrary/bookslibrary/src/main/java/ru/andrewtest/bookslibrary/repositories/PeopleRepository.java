package ru.andrewtest.bookslibrary.repositories;

import ru.andrewtest.bookslibrary.models.Person;

import java.util.List;

public interface PeopleRepository {
    public List<Person> findAll();
}
