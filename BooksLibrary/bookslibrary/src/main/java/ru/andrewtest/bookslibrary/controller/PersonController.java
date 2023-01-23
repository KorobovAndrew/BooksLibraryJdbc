package ru.andrewtest.bookslibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.andrewtest.bookslibrary.models.Book;
import ru.andrewtest.bookslibrary.models.Person;
import ru.andrewtest.bookslibrary.repositories.BooksRepository;
import ru.andrewtest.bookslibrary.repositories.PeopleRepository;

import java.util.List;

@Controller
public class PersonController {
    private final PeopleRepository peopleRepository;
    private final BooksRepository booksRepository;

    @Autowired
    public PersonController(PeopleRepository peopleRepository, BooksRepository booksRepository) {
        this.peopleRepository = peopleRepository;
        this.booksRepository = booksRepository;
    }

    @GetMapping("/people")
    public String getPeople(Model model) {
        List<Person> people = peopleRepository.findAll();
        model.addAttribute("people", people);
        return "people";
    }

    @GetMapping("/people/new")
    public String getPersonAdditionPage(){
        return "redirect:/person_addition.html";
    }

    @PostMapping("/people/new")
    public String addPerson(@RequestParam("fullName") String fullName,
                            @RequestParam("yearOfBirth") Integer yearOfBirth){
        peopleRepository.addPerson(fullName, yearOfBirth);
        return "redirect:/people";
    }

    @GetMapping("/people/{person-id}/edit")
    public String getPersonEditingPage(Model model, @PathVariable("person-id") int personId){
        Person person = peopleRepository.findPersonById(personId);
        model.addAttribute("person", person);
        return "person_editing";
    }

    @PostMapping("/people/{person-id}/edit")
    public String editPerson(@PathVariable("person-id") int personId,
                             @RequestParam("fullName") String fullName,
                             @RequestParam("yearOfBirth")Integer yearOfBirth){
        peopleRepository.editPerson(personId, fullName, yearOfBirth);
        return "redirect:/people";
    }

    @GetMapping("/people/{person-id}")
    public String getPersonPage(Model model, @PathVariable("person-id") int personId){
        Person person = peopleRepository.findPersonById(personId);
        List<Book> books = booksRepository.findBooksByPersonId(personId);
        model.addAttribute("person", person);
        model.addAttribute("books", books);
        return "person";
    }

    @PostMapping("/people/{person-id}/delete")
    public String deletePerson(@PathVariable("person-id") int personId){
        peopleRepository.deletePerson(personId);
        return "redirect:/people";
    }
}