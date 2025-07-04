package com.SOA.paie;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public  class Employe {

    private @Id
    @GeneratedValue Long id;
    private String name;
    private String role;



    Employe(String name, String role) {

        this.name = name;
        this.role = role;
    }

    public Employe() {

    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getRole() {
        return this.role;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Employe))
            return false;
        Employe Employe = (Employe) o;
        return Objects.equals(this.id, Employe.id) && Objects.equals(this.name, Employe.name)
                && Objects.equals(this.role, Employe.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.role);
    }

    @Override
    public String toString() {
        return "com.SOA.paie.Employe{" + "id=" + this.id + ", name='" + this.name + '\'' + ", role='" + this.role + '\'' + '}';
    }
}