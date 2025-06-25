package com.SOA.paie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeRepository repository,DepartementRepository Drepository) {

        return args -> {
            log.info("Preloading " + repository.save(new Employe("Bilbo Baggins", "burglar")));
            log.info("Preloading " + repository.save(new Employe("Frodo Baggins", "thief")));
            log.info("Preloading " + Drepository.save(new Departement("Bilbo Baggins", "dasq")));
            log.info("Preloading " + Drepository.save(new Departement("Frodo Baggins", "daze")));
        };
    }



}