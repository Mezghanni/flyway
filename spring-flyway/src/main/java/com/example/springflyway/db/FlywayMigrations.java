package com.example.springflyway.db;

import com.example.springflyway.db.migration.U5__Anonymize;
import com.example.springflyway.db.migration.U7__Insert_person;
import com.example.springflyway.db.migration.V5__Anonymize;
import com.example.springflyway.db.migration.V7__Insert_person;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.MigrationInfoService;
import org.flywaydb.core.api.migration.JavaMigration;
import org.flywaydb.core.internal.info.MigrationInfoDumper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
@Configuration
public class FlywayMigrations implements CommandLineRunner {

    @Autowired
    private V7__Insert_person insert_person;

    @Autowired
    private U7__Insert_person insert_person_u;

    @Autowired
    private V5__Anonymize anonymize;

    @Autowired
    private U5__Anonymize anonymize_u;

    @Autowired
    private DataSource dataSource;

    @Value("${my-app.flyway.license}")
    private String license;

    @Override
    public void run(String... args) {
        JavaMigration migrations[] = {
                insert_person,
                insert_person_u,
                anonymize,
                anonymize_u
        };
        Flyway flyway = Flyway.configure()
                .licenseKey(license)
                .dataSource(dataSource)
                .javaMigrations(migrations)
                .load();
        System.out.println(MigrationInfoDumper.dumpToAsciiTable(flyway.info().all()));
        flyway.clean();
        System.out.println(MigrationInfoDumper.dumpToAsciiTable(flyway.info().all()));
        flyway.migrate();
        System.out.println(MigrationInfoDumper.dumpToAsciiTable(flyway.info().all()));
    }
}
