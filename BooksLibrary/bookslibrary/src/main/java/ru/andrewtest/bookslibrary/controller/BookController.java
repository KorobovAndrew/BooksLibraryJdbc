package ru.andrewtest.bookslibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.andrewtest.bookslibrary.models.Book;
import ru.andrewtest.bookslibrary.repositories.BooksRepository;

import java.util.List;

@Controller
public class BookController {
    private final BooksRepository booksRepository;

    @Autowired
    public BookController(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    @GetMapping("/books")
    public String getBooks(Model model){
        List<Book> books = booksRepository.findAll();
        model.addAttribute("books", books);
        return "/books";
    }
}
