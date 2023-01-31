package ru.andrewtest.bookslibrary.factories;

import ru.andrewtest.bookslibrary.forms.PersonDto;
import ru.andrewtest.bookslibrary.models.Person;

public class PersonDtoFactory {
    public static PersonDto createPersonDto(Person person) {
        return PersonDto.builder()
                .fullName(person.getFullName())
                .yearOfBirth(person.getYearOfBirth())
                .build();
    }
}
