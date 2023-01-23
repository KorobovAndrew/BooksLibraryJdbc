package ru.andrewtest.bookslibrary.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Book {
    int id;
    private String title;
    private String author;
    private Integer yearOfWriting;
}
