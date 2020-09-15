package com.example.springflyway;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Integer> {

    List<Person> findByName(String name);

    Person findById(long id);
}
