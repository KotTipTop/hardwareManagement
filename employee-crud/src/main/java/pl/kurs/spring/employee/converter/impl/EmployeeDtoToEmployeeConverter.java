package pl.kurs.spring.employee.converter.impl;

import org.springframework.stereotype.Service;

import pl.kurs.spring.converter.SimpleObjectConverter;
import pl.kurs.spring.employee.dto.EmployeeDTO;
import pl.kurs.spring.employee.model.Employee;

@Service
public class EmployeeDtoToEmployeeConverter implements SimpleObjectConverter<EmployeeDTO, Employee>{

	@Override
	public Employee mapTo(EmployeeDTO from) {
		return Employee.builder().id(from.getId()).name(from.getName()).surname(from.getSurname()).salary(from.getSalary()).position(from.getPosition()).build();
	}

}
