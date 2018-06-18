package pl.kurs.spring.employee.converter.impl;

import org.springframework.stereotype.Service;

import pl.kurs.spring.converter.SimpleObjectConverter;
import pl.kurs.spring.employee.command.EmployeeEditCommand;
import pl.kurs.spring.employee.model.Employee;

@Service
public class EmployeeEditCommandToEmployeeConverter implements SimpleObjectConverter<EmployeeEditCommand, Employee> {

	@Override
	public Employee mapTo(EmployeeEditCommand from) {
		return Employee.builder().id(from.getId()).name(from.getName()).surname(from.getSurname()).position(from.getPosition()).salary(from.getSalary()).active(from.isActive()).build();
	}

}
