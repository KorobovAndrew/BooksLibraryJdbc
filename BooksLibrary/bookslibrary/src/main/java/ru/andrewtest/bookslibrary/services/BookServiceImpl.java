package ru.andrewtest.bookslibrary.services;

import org.springframework.stereotype.Component;
import ru.andrewtest.bookslibrary.factories.BookDtoFactory;
import ru.andrewtest.bookslibrary.forms.BookDto1;
import ru.andrewtest.bookslibrary.forms.BookDto2;
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
    public List<BookDto1> findAllBookDto1() {
        List<Book> books = bookRepository.findAll();
        return books.stream()
                .map(BookDtoFactory::createBookDto1)
                .toList();
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
    public BookDto1 findBookDto1ById(int bookId) {
        Book book = bookRepository.findBookById(bookId);
        return BookDtoFactory.createBookDto1(book);
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
    public List<BookDto2> findAllBookDto2ByPersonId(int personId) {
        List<Book> books = bookRepository.findBooksByPersonId(personId);
        return books.stream()
                .map(BookDtoFactory::createBookDto2)
                .toList();
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
