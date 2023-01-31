package ru.andrewtest.bookslibrary.services;

import ru.andrewtest.bookslibrary.models.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();

    void addBook(String title, String author, Integer yearOfWriting);

    Book findBookById(int bookId);

    void updateBook(String title, String author, Integer yearOfWriting, int bookId);

    void deleteBookById(int bookId);

    List<Book> findBooksByPersonId(int personId);

    void deleteLinkOnPerson(int bookId);

    void updateBorrowerId(String newBorrower, int bookId);
}
