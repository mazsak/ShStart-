package com.example.demo.repository;

import com.example.demo.models.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonRepo extends CrudRepository<Person, Long> {}
