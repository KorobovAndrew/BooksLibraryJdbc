package ru.andrewtest.bookslibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.andrewtest.bookslibrary.models.Person;
import ru.andrewtest.bookslibrary.repositories.PeopleRepository;

import java.util.List;

@Controller
public class PersonController {
    private final PeopleRepository peopleRepository;

    @Autowired
    public PersonController(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
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
    public String getPersonPage(Model model, @PathVariable("person-id") int personId){
        Person person = peopleRepository.getPersonById(personId);
        model.addAttribute("person", person);
        return "person";
    }

    @PostMapping("/people/{person-id}/edit")
    public String editPerson(@PathVariable("person-id") int personId,
                             @RequestParam("fullName") String fullName,
                             @RequestParam("yearOfBirth")Integer yearOfBirth){
        peopleRepository.editPerson(personId, fullName, yearOfBirth);
        return "redirect:/people";
    }
}
