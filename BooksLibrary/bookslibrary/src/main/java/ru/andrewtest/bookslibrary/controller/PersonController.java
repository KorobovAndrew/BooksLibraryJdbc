package ru.andrewtest.bookslibrary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.andrewtest.bookslibrary.forms.PersonDto;
import ru.andrewtest.bookslibrary.models.Book;
import ru.andrewtest.bookslibrary.models.Person;
import ru.andrewtest.bookslibrary.services.BookService;
import ru.andrewtest.bookslibrary.services.PersonService;

import java.util.List;

@RequestMapping("/people")
@Controller
public class PersonController {

    private final BookService bookService;
    private final PersonService personService;

    public PersonController(BookService bookService, PersonService personService) {
        this.bookService = bookService;
        this.personService = personService;
    }

    @GetMapping
    public String getPeople(Model model) {
        List<Person> people = personService.findAllPeople();
        model.addAttribute("people", people);
        return "people";
    }

    @PostMapping("/new")
    public String addPerson(@RequestParam("fullName") String fullName,
                            @RequestParam("yearOfBirth") Integer yearOfBirth) {
        personService.addPerson(fullName, yearOfBirth);
        return "redirect:/people";
    }

    @GetMapping("/{person-id}/edit")
    public String getPersonEditingPage(Model model, @PathVariable("person-id") int personId) {
        Person person = personService.findPersonById(personId);
        model.addAttribute("person", person);
        return "person_editing";
    }

    @PostMapping("/{person-id}/edit")
    public String editPerson(@PathVariable("person-id") int personId,
                             @RequestParam("fullName") String fullName,
                             @RequestParam("yearOfBirth") Integer yearOfBirth) {
        personService.updatePerson(personId, fullName, yearOfBirth);
        return "redirect:/people";
    }

    @GetMapping("/{person-id}")
    public String getPersonPage(Model model, @PathVariable("person-id") int personId) {
        Person person = personService.findPersonById(personId);
        List<Book> books = bookService.findBooksByPersonId(personId);
        model.addAttribute("person", person);
        model.addAttribute("books", books);
        return "person";
    }

    @PostMapping("/{person-id}/delete")
    public String deletePerson(@PathVariable("person-id") int personId) {
        personService.deletePerson(personId);
        return "redirect:/people";
    }
}