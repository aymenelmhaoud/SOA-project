package com.SOA.paie;

class EmployeNotFoundException extends RuntimeException {

    EmployeNotFoundException(Long id) {
        super("Could not find employee " + id);
    }
}