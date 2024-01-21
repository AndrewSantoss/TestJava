package com.enterprise.management.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.enterprise.management.entities.Employees;
import com.enterprise.management.repositories.EmployeesRepository;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeesRepository repository;
	
	@GetMapping
	public List<Employees> findAll(){
		List<Employees> result = repository.findAll();
		return result;
	}
	
	@GetMapping(value = "/{id}")
	public Employees findById(@PathVariable Long id){
		Employees result = repository.findById(id).get();
		return result;
	}
	
	@PostMapping
	public Employees insert( @RequestBody Employees employee){
		Employees result = repository.save(employee);
		return result;
	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployeeById(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
	
	@GetMapping("/cep/{cep}")
	public ResponseEntity<Employees> getEmployeeByCep(@PathVariable String cep) {
	    Optional<Employees> employee = repository.findByCep(cep);

	    if (employee.isPresent()) {
	        return ResponseEntity.ok(employee.get());
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	    }
	}
	
	@PutMapping("/employees/{id}")
    public Employees updateEmployee(@PathVariable Long id, @RequestBody Employees employee) {
        Optional<Employees> employeeOptional = repository.findById(id);
        if (!employeeOptional.isPresent()) {
            throw new RuntimeException("Employee not found");
        }
        employee.setId(id);
        return repository.save(employee);
    }
	
	@PatchMapping("/{id}")
    public ResponseEntity<Employees> halfUpdate(@PathVariable Long id, @RequestBody Employees request) {
        Optional<Employees> employeeOptional = repository.findById(id);

        Employees employee = employeeOptional.get();

        if (request.getName() != null) {
            employee.setName(request.getName());
        }
        if (request.getAge() != 0) {
            employee.setAge(request.getAge());
        }
        if (request.getCep() != 0) {
            employee.setCep(request.getCep());
        }
        if (request.getSex() != null) {
            employee.setSex(request.getSex());
        }
        if (request.getAddress() != null) {
            employee.setAddress(request.getAddress());
        }
        if (request.getZone() != null) {
            employee.setZone(request.getZone());
        }
        if (request.getCity() != null) {
            employee.setCity(request.getCity());
        }
        if (request.getState() != null) {
            employee.setState(request.getState());
        }
        
        Employees updatedEmployee = repository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }
	
}
