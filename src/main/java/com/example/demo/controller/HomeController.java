package com.example.demo.controller;

import com.example.demo.PeopleCreationDto;
import com.example.demo.models.Person;
import com.example.demo.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    IPersonService personService;

    @RequestMapping({"/", ""})
    public String home() {
        return "home";
    }

    @GetMapping(value = "/all")
    public String all(Model model) {
        PeopleCreationDto peopleCreationDto = new PeopleCreationDto();
        List<Person> people = personService.findAll();
        peopleCreationDto.addPeople(people);
        model.addAttribute("form", peopleCreationDto);
        return "all";
    }

    @GetMapping(value = "person")
    public String one(Model model, @RequestParam String id) {
        Person person = personService.findById(Long.parseLong(id));
        model.addAttribute("person", person);
        return "person";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("person", new Person());
        return "save";
    }


    @PostMapping("/saveAll")
    public String save(@ModelAttribute PeopleCreationDto form, Model model) {
        if(!form.getPeople().get(form.getPeople().size() - 1).getName().equals(""))
        personService.saveAll(form.getPeople());

        model.addAttribute("people", personService.findAll());

        return "redirect:/all";
    }

    @GetMapping("/edit")
    public String edit( Model model){
        PeopleCreationDto peopleCreationDto = new PeopleCreationDto();
        List<Person> people = personService.findAll();
        peopleCreationDto.addPeople(people);
        model.addAttribute("form", peopleCreationDto);
        return "edit";
    }

}
