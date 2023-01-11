package ru.andrewtest.bookslibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
}
