package com.example.demo;

import com.example.demo.models.Person;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Setter
@Getter
public class PeopleCreationDto {
    private List<Person> people;

    public PeopleCreationDto() {
        this.people = new ArrayList<>();
    }

    public void addPerosn(Person person){
        people.add(person);
    }

    public void addPeople(List<Person> people){
        this.people.addAll(people);
    }
}
