package ru.andrewtest.bookslibrary.repositories;

import ru.andrewtest.bookslibrary.models.Book;

import java.util.List;

public interface BooksRepository {
    public List<Book> findAll();
}
