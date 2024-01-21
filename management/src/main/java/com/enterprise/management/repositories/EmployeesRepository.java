package com.enterprise.management.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.enterprise.management.entities.Employees;

public interface EmployeesRepository extends JpaRepository<Employees, Long> {
	
	@Query("SELECT e FROM Employees e WHERE e.cep = :cep")
    Optional<Employees> findByCep(@Param("cep") String cep);
	
}