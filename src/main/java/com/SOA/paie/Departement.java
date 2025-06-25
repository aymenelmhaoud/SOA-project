package com.SOA.paie;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public  class Departement {

    private @Id
    @GeneratedValue Long id;
    private String nom;
    private String coded;



    Departement(String nom, String coded) {

        this.nom = nom;
        this.coded = coded;
    }

    public Departement() {

    }

    public Long getId() {
        return this.id;
    }

    public String getNom() {
        return this.nom;
    }

    public String getCoded() {
        return this.coded;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCoded(String coded) {
        this.coded = coded;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Departement))
            return false;
        Departement Departement = (Departement) o;
        return Objects.equals(this.id, Departement.id) && Objects.equals(this.nom, Departement.nom)
                && Objects.equals(this.coded, Departement.coded);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.nom, this.coded);
    }

    @Override
    public String toString() {
        return "com.SOA.paie.Employe{" + "id=" + this.id + ", nom='" + this.nom + '\'' + ", coded='" + this.coded + '\'' + '}';
    }
}