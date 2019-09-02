package com.example.demo.service;

import com.example.demo.models.Person;

import java.util.List;

public interface IPersonService {
    boolean save(Person person);
    boolean saveAll(List<Person> people);

    boolean update(Person person);

    boolean delete(Long id);

    List<Person> findAll();

    Person findById(Long id);
}
