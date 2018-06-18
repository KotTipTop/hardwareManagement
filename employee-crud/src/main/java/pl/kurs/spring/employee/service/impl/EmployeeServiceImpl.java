package pl.kurs.spring.employee.service.impl;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import pl.kurs.spring.employee.model.Employee;
import pl.kurs.spring.employee.repository.EmployeeRepository;
import pl.kurs.spring.employee.service.EmployeeService;

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
	public Optional<Employee> findOne(Long id) {
		return Optional.ofNullable(employeeRepository.findOne(id));
	}

	@Override
	public void delete(Long id) {
		Employee e = employeeRepository.findOne(id);
		e.setActive(false);
		employeeRepository.saveAndFlush(e);

	}

	@Override
	public Employee save(Employee model) {
		return employeeRepository.saveAndFlush(model);
	}



	@Override
	public Page<Employee> findAllAcitves(Pageable pageable, String query) {
		//to można wrzucić do findall po prostu, chyba ze findall bylby dla admina gdzie widzi wszystkich 
		return employeeRepository.findAllActive(pageable,Optional.ofNullable(query).map(String::toUpperCase).orElse(""));
	}

	@Override
	public Optional<Employee> findOneActive(Long id) {
		return employeeRepository.findOneActive(id);
	}

}
