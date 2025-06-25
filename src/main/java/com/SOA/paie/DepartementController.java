package com.SOA.paie;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class DepartementController {

    private final DepartementRepository repository;

    DepartementController(DepartementRepository repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/Departements")
    List<Departement> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/Departements")
    Departement newDepartement(@RequestBody Departement newDepartement) {
        return repository.save(newDepartement);
    }

    // Single item

    @GetMapping("/Departements/{id}")
    Departement one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new DepartementNotFoundException(id));
    }

    @PutMapping("/Departements/{id}")
   Departement replaceDepartement(@RequestBody Departement newDepartement, @PathVariable Long id) {

        return repository.findById(id)
                .map(Employe -> {
                    Employe.setNom(newDepartement.getNom());
                    Employe.setCoded(newDepartement.getCoded());
                    return repository.save(Employe);
                })
                .orElseGet(() -> {
                    newDepartement.setId(id);
                    return repository.save(newDepartement);
                });
    }

    @DeleteMapping("/Departements/{id}")
    void deleteDepartement(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @GetMapping("/Departements/count")
    Long countdepartement() {
        return repository.count();
    }
}
