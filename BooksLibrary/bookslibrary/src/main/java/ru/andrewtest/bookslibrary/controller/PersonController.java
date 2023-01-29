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

@RequestMapping("/people")
@Controller
public class PersonController {
    private final PeopleRepository peopleRepository;
    private final BooksRepository booksRepository;

    @Autowired
    public PersonController(PeopleRepository peopleRepository, BooksRepository booksRepository) {
        this.peopleRepository = peopleRepository;
        this.booksRepository = booksRepository;
    }

    @GetMapping
    public String getPeople(Model model) {
        List<Person> people = peopleRepository.findAll();
        model.addAttribute("people", people);
        return "people";
    }

    @PostMapping("/new")
    public String addPerson(@RequestParam("fullName") String fullName,
                            @RequestParam("yearOfBirth") Integer yearOfBirth){
        peopleRepository.addPerson(fullName, yearOfBirth);
        return "redirect:/people";
    }

    @GetMapping("/{person-id}/edit")
    public String getPersonEditingPage(Model model, @PathVariable("person-id") int personId){
        Person person = peopleRepository.findPersonById(personId);
        model.addAttribute("person", person);
        return "person_editing";
    }

    @PostMapping("/{person-id}/edit")
    public String editPerson(@PathVariable("person-id") int personId,
                             @RequestParam("fullName") String fullName,
                             @RequestParam("yearOfBirth")Integer yearOfBirth){
        peopleRepository.updatePerson(personId, fullName, yearOfBirth);
        return "redirect:/people";
    }

    @GetMapping("/{person-id}")
    public String getPersonPage(Model model, @PathVariable("person-id") int personId){
        Person person = peopleRepository.findPersonById(personId);
        List<Book> books = booksRepository.findBooksByPersonId(personId);
        model.addAttribute("person", person);
        model.addAttribute("books", books);
        return "person";
    }

    @PostMapping("/{person-id}/delete")
    public String deletePerson(@PathVariable("person-id") int personId){
        peopleRepository.deletePerson(personId);
        return "redirect:/people";
    }
}