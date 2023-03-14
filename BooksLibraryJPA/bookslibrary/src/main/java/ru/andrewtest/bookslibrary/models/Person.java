package ru.andrewtest.bookslibrary.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Person {
    int id;
    private String fullName;
    private Integer yearOfBirth;
}
