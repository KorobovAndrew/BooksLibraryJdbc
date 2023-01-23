package ru.andrewtest.bookslibrary.repositories;

import ru.andrewtest.bookslibrary.models.Book;

import java.util.List;

public interface BooksRepository {
    List<Book> findAll();

    List<Book> findBooksByPersonId(int personId);
}
