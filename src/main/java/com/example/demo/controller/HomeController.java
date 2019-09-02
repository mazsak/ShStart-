package com.example.demo.controller;

import com.example.demo.models.Person;
import com.example.demo.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    IPersonService personService;

    @RequestMapping({"/",""})
    public String home(){
        /*Person person = new Person();
        person.setName("Jan");
        person.setAge(15);
        person.setSurname("Kowalski");
        person.setDescription("Jakis tam Jan");
        personService.save(person);*/
        return "home";
    }
    @GetMapping(value = "/all")
    public String  all(Model model) {
       model.addAttribute("persons", personService.findAll());
       return "all";
    }
    @GetMapping(value = "person")
    public String one(Model model, @RequestParam String id){
       Person person = personService.findById(Long.parseLong(id));
       model.addAttribute("person",person);
        return "person";
    }


}
