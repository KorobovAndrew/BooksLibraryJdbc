package ru.andrewtest.bookslibrary.factories;

import ru.andrewtest.bookslibrary.forms.PersonDto1;
import ru.andrewtest.bookslibrary.forms.PersonDto2;
import ru.andrewtest.bookslibrary.models.Person;

public class PersonDtoFactory {
    public static PersonDto1 createPersonDto1(Person person) {
        return PersonDto1.builder()
                .fullName(person.getFullName())
                .yearOfBirth(person.getYearOfBirth())
                .build();
    }

    public static PersonDto2 createPersonDto2(Person person) {
        return PersonDto2.builder()
                .fullName(person.getFullName())
                .build();
    }
}
