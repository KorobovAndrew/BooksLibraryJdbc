package ru.andrewtest.bookslibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.andrewtest.bookslibrary.models.Book;
import ru.andrewtest.bookslibrary.models.Person;
import ru.andrewtest.bookslibrary.repositories.BooksRepository;
import ru.andrewtest.bookslibrary.repositories.PeopleRepository;

import java.util.List;

@RequestMapping("/books")
@Controller
public class BookController {
    private final BooksRepository booksRepository;
    private final PeopleRepository peopleRepository;

    @Autowired
    public BookController(BooksRepository booksRepository, PeopleRepository peopleRepository) {
        this.booksRepository = booksRepository;
        this.peopleRepository = peopleRepository;
    }

    @GetMapping
    public String getBooks(Model model) {
        List<Book> books = booksRepository.findAll();
        model.addAttribute("books", books);
        return "/books";
    }

    @PostMapping("/new")
    public String addBook(@RequestParam("title") String title,
                          @RequestParam("author") String author,
                          @RequestParam("yearOfWriting") Integer yearOfWriting) {
        booksRepository.addBook(title, author, yearOfWriting);
        return "redirect:/books";
    }

    @GetMapping("/{book-id}/edit")
    public String getBookEditingPage(Model model, @PathVariable("book-id") int bookId) {
        Book book = booksRepository.findBookById(bookId);
        model.addAttribute("book", book);
        return "book_editing";
    }

    @PostMapping("/{book-id}/edit")
    public String editBook(@PathVariable("book-id") int bookId,
                           @RequestParam("title") String title,
                           @RequestParam("author") String author,
                           @RequestParam("yearOfWriting") Integer yearOfWriting) {
        booksRepository.updateBook(title, author, yearOfWriting, bookId);
        return "redirect:/books";
    }

    @GetMapping("/{book-id}")
    public String getBookPage(Model model, @PathVariable("book-id") int bookId) {
        Book book = booksRepository.findBookById(bookId);
        List<Person> people = peopleRepository.findAll();
        Person person = null;
        if (book.getBorrowerId() != 0)
            person = peopleRepository.findPersonById(book.getBorrowerId());
        model.addAttribute("book", book);
        model.addAttribute("borrower", person);
        model.addAttribute("people", people);
        return "book";
    }

    @PostMapping("/{book-id}/delete")
    public String deleteBook(@PathVariable("book-id") int bookId) {
        booksRepository.deleteBookById(bookId);
        return "redirect:/books";
    }

    @PostMapping("/{book-id}/free-up")
    public String freeUpTheBook(@PathVariable("book-id") int bookId) {
        booksRepository.deleteLinkOnPerson(bookId);
        return "redirect:/books/{book-id}";
    }

    @PostMapping("/{book-id}/updateBorrower")
    public String updateBorrower(String newBorrower, @PathVariable("book-id") int bookId) {
        booksRepository.updateBorrowerId(newBorrower, bookId);
        return "redirect:/books/{book-id}";
    }
}
