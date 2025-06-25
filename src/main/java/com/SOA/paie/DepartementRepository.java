package com.SOA.paie;

import com.SOA.paie.Departement;
import org.springframework.data.jpa.repository.JpaRepository;

interface DepartementRepository extends JpaRepository<Departement, Long> {


}