package pl.kurs.spring.employee.validation.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.kurs.spring.employee.repository.EmployeeRepository;
import pl.kurs.spring.employee.validation.annotation.CheckIfEmployeeIdExists;

@Service
public class CheckIfEmployeeIdExistsValidator implements ConstraintValidator<CheckIfEmployeeIdExists, Long> {
	private final EmployeeRepository employeeRepository;

	public CheckIfEmployeeIdExistsValidator(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public void initialize(CheckIfEmployeeIdExists arg0) {

	}

	@Override
	public boolean isValid(Long id, ConstraintValidatorContext arg1) {
		if (id == null) {
			return false;
		}
		return employeeRepository.findOne(id) != null;
	}

}
