package com.example.springflyway.db.migration;

import com.example.springflyway.Person;
import com.example.springflyway.PersonRepository;
import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class V7__Insert_person extends BaseJavaMigration {

    @Autowired
    private PersonRepository repository;

    public void migrate(Context context) throws Exception {
        // save a few persons
        repository.save(new Person("Jack"));
        repository.save(new Person("Chloe"));
        repository.save(new Person("Kim"));
        repository.save(new Person("David"));
        repository.save(new Person("Michelle"));
    }
}
