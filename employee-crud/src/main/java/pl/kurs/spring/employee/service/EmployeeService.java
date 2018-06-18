package pl.kurs.spring.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import pl.kurs.spring.employee.model.Employee;

public interface EmployeeService {
	List<Employee> findAll();

	Optional<Employee> findOne(Long id);

	Employee save(Employee model);
	
	void delete(Long id);	
	Page<Employee> findAllAcitves(Pageable pageable, String query);
	Optional<Employee> findOneActive(Long id);

}
