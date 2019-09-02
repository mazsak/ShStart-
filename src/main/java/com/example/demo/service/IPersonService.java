package com.example.demo.service;

import com.example.demo.models.Person;

import java.util.List;

public interface IPersonService {
    boolean save(Person person);

    boolean update(Person person);

    boolean delete(Long id);

    List<Person> findAll();

    Person findById(Long id);
}
