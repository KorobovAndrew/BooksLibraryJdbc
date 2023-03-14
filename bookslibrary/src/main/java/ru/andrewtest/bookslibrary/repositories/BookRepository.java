package ru.andrewtest.bookslibrary.repositories;

import ru.andrewtest.bookslibrary.models.Book;

import java.util.List;

public interface BookRepository {
    List<Book> findAll();

    List<Book> findBooksByPersonId(int personId);

    void addBook(String title, String author, Integer yearOfWriting);

    Book findBookById(int bookId);

    void updateBook(String title, String author, Integer yearOfWriting, int bookId);

    void deleteBookById(int bookId);

    void deleteLinkOnPerson(int bookId);

    void updateBorrowerId(String newBorrower, int bookId);
}
