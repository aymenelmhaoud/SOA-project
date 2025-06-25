package com.SOA.paie;

import com.SOA.paie.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

interface EmployeRepository extends JpaRepository<Employe, Long> {


}