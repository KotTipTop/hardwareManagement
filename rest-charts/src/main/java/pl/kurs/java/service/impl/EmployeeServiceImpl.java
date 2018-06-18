package pl.kurs.java.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.kurs.java.model.Employee;
import pl.kurs.java.repository.EmployeeRepository;
import pl.kurs.java.service.EmployeeService;

@Transactional
@Service
public class EmployeeServiceImpl implements EmployeeService {
	private final EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee save(Employee model) {
		return employeeRepository.saveAndFlush(model);
	}
// service chart i metoda klucz chart a wartosc interfejs i jego implementacja - potem strategia hashmap 
	

}
