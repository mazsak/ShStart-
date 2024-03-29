package com.example.demo.service;

import com.example.demo.models.Person;
import com.example.demo.repository.IPersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements IPersonService {

    @Autowired
    private IPersonRepo personRepo;

    @Override
    public boolean save(Person person) {
        Person save = personRepo.save(person);
        return false;
    }

    @Override
    public boolean saveAll(List<Person> people) {
        List<Person> save = personRepo.saveAll(people);
        if (save != null) {
            return true;
        }

        return false;
    }

    @Override
    public boolean update(Person person) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public List<Person> findAll() {
        List<Person> personList = personRepo.findAll();
        return personList;
    }

    @Override
    public Person findById(Long id) {
        Person person = personRepo.findById(id).get();
        return person;
    }
}
