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
class EmployeController {

    private final EmployeRepository repository;

    EmployeController(EmployeRepository repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/employes")
    List<Employe> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/employes")
    Employe newEmploye(@RequestBody Employe newEmploye) {
        return repository.save(newEmploye);
    }

    // Single item

    @GetMapping("/employes/{id}")
    Employe one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new EmployeNotFoundException(id));
    }

    @PutMapping("/employes/{id}")
    Employe replaceEmploye(@RequestBody Employe newEmploye, @PathVariable Long id) {

        return repository.findById(id)
                .map(Employe -> {
                    Employe.setName(newEmploye.getName());
                    Employe.setRole(newEmploye.getRole());
                    return repository.save(Employe);
                })
                .orElseGet(() -> {
                    newEmploye.setId(id);
                    return repository.save(newEmploye);
                });
    }

    @DeleteMapping("/employes/{id}")
    void deleteEmploye(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @GetMapping("/employes/count")
    Long countEmployes() {
        return repository.count();
    }
}
