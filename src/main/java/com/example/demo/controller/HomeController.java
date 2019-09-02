package com.example.demo.controller;

import com.example.demo.models.Person;
import com.example.demo.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String  all(Model model) {
       model.addAttribute("persons", personService.findAll());
       return "all";
    }


}
