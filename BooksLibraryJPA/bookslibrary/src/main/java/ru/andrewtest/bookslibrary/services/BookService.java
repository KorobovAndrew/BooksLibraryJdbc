package ru.andrewtest.bookslibrary.services;

import ru.andrewtest.bookslibrary.forms.BookDto1;
import ru.andrewtest.bookslibrary.forms.BookDto2;
import ru.andrewtest.bookslibrary.models.Book;

import java.util.List;

public interface BookService {

    List<BookDto1> findAllBookDto1();

    void addBook(String title, String author, Integer yearOfWriting);

    Book findBookById(int bookId);

    BookDto1 findBookDto1ById(int bookId);

    void updateBook(String title, String author, Integer yearOfWriting, int bookId);

    void deleteBookById(int bookId);

    List<BookDto2> findAllBookDto2ByPersonId(int personId);

    void deleteLinkOnPerson(int bookId);

    void updateBorrowerId(String newBorrower, int bookId);
}
