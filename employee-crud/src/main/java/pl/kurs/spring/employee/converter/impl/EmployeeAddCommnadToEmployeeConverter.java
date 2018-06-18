package pl.kurs.spring.employee.converter.impl;

import org.springframework.stereotype.Service;

import pl.kurs.spring.converter.SimpleObjectConverter;
import pl.kurs.spring.employee.command.EmployeeAddCommand;
import pl.kurs.spring.employee.model.Employee;

@Service
public class EmployeeAddCommnadToEmployeeConverter implements SimpleObjectConverter<EmployeeAddCommand, Employee> {

	@Override
	public Employee mapTo(EmployeeAddCommand from) {
		return Employee.builder().name(from.getName()).surname(from.getSurname()).position(from.getPosition()).salary(from.getSalary()).active(true).build();
	}

}
