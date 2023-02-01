package ru.andrewtest.bookslibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.andrewtest.bookslibrary.forms.BookDto1;
import ru.andrewtest.bookslibrary.forms.PersonDto1;
import ru.andrewtest.bookslibrary.forms.PersonDto2;
import ru.andrewtest.bookslibrary.models.Book;
import ru.andrewtest.bookslibrary.services.BookService;
import ru.andrewtest.bookslibrary.services.PersonService;

import java.util.List;

@RequestMapping("/books")
@Controller
public class BookController {
    private final BookService bookService;
    private final PersonService personService;

    @Autowired
    public BookController(BookService bookService, PersonService personService) {
        this.bookService = bookService;
        this.personService = personService;
    }

    @GetMapping
    public String getBooks(Model model) {
        List<BookDto1> books = bookService.findAllBookDto1();
        model.addAttribute("books", books);
        return "/books";
    }

    @PostMapping("/new")
    public String addBook(@RequestParam("title") String title,
                          @RequestParam("author") String author,
                          @RequestParam("yearOfWriting") Integer yearOfWriting) {
        bookService.addBook(title, author, yearOfWriting);
        return "redirect:/books";
    }

    @GetMapping("/{book-id}/edit")
    public String getBookEditingPage(Model model, @PathVariable("book-id") int bookId) {
        BookDto1 book = bookService.findBookDto1ById(bookId);
        model.addAttribute("book", book);
        return "book_editing";
    }

    @PostMapping("/{book-id}/edit")
    public String editBook(@PathVariable("book-id") int bookId,
                           @RequestParam("title") String title,
                           @RequestParam("author") String author,
                           @RequestParam("yearOfWriting") Integer yearOfWriting) {
        bookService.updateBook(title, author, yearOfWriting, bookId);
        return "redirect:/books";
    }

    @GetMapping("/{book-id}")
    public String getBookPage(Model model, @PathVariable("book-id") int bookId) {
        Book book = bookService.findBookById(bookId);
        List<PersonDto1> people = personService.findAllPersonDto1();
        PersonDto2 person= personService.findPersonDto2ById(book.getBorrowerId());
        model.addAttribute("book", book);
        model.addAttribute("borrower", person);
        model.addAttribute("people", people);
        return "book";
    }

    @PostMapping("/{book-id}/delete")
    public String deleteBook(@PathVariable("book-id") int bookId) {
        bookService.deleteBookById(bookId);
        return "redirect:/books";
    }

    @PostMapping("/{book-id}/free-up")
    public String freeUpTheBook(@PathVariable("book-id") int bookId) {
        bookService.deleteLinkOnPerson(bookId);
        return "redirect:/books/{book-id}";
    }

    @PostMapping("/{book-id}/updateBorrower")
    public String updateBorrower(@RequestParam("newBorrower") String newBorrower,
                                 @PathVariable("book-id") int bookId) {
        bookService.updateBorrowerId(newBorrower, bookId);
        return "redirect:/books/{book-id}";
    }
}
