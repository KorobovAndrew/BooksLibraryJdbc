package ru.andrewtest.bookslibrary.services;

import org.springframework.stereotype.Component;
import ru.andrewtest.bookslibrary.models.Book;
import ru.andrewtest.bookslibrary.repositories.BookRepository;

import java.util.List;

@Component
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public void addBook(String title, String author, Integer yearOfWriting) {
        bookRepository.addBook(title, author, yearOfWriting);
    }

    @Override
    public Book findBookById(int bookId) {
        return bookRepository.findBookById(bookId);
    }

    @Override
    public void updateBook(String title, String author, Integer yearOfWriting, int bookId) {
        bookRepository.updateBook(title, author, yearOfWriting, bookId);
    }

    @Override
    public void deleteBookById(int bookId) {
        bookRepository.deleteBookById(bookId);
    }

    @Override
    public List<Book> findBooksByPersonId(int personId) {
        return bookRepository.findBooksByPersonId(personId);
    }

    @Override
    public void deleteLinkOnPerson(int bookId) {
        bookRepository.deleteLinkOnPerson(bookId);
    }

    @Override
    public void updateBorrowerId(String newBorrower, int bookId) {
        bookRepository.updateBorrowerId(newBorrower, bookId);
    }
}
