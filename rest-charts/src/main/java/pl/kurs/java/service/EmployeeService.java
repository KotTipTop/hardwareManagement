package pl.kurs.java.service;

import java.util.List;

import pl.kurs.java.model.Employee;

public interface EmployeeService {
	List<Employee> findAll();
	Employee save(Employee model);
}
