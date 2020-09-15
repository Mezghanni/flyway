package com.example.springflyway.db.migration;

import com.example.springflyway.PersonRepository;
import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class U7__Insert_person extends BaseJavaMigration {

    @Autowired
    private PersonRepository repository;

    public void migrate(Context context) throws Exception {
        // delete a few persons
        repository.findByName("Jack").forEach(person -> {
            repository.delete(person);
        });
        repository.findByName("Chloe").forEach(person -> {
            repository.delete(person);
        });
        repository.findByName("Kim").forEach(person -> {
            repository.delete(person);
        });
        repository.findByName("David").forEach(person -> {
            repository.delete(person);
        });
        repository.findByName("Michelle").forEach(person -> {
            repository.delete(person);
        });
    }
}
