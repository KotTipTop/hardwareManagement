package pl.kurs.java.service;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;


import pl.kurs.java.model.Employee;
import pl.kurs.java.repository.EmployeeRepository;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceImplTest {
	@Mock
	private EmployeeRepository employeeRepository;
	
	@InjectMocks
	private EmployeeService employeeService;
	
	
	@Test
	public void shouldGetEmployeeList() {
		//given
		Mockito.when(employeeRepository.findAll()).thenReturn(Arrays.asList(new Employee(), new Employee()));
		//when
		List<Employee> employees = employeeService.findAll();
		//then
		Assert.assertEquals(2, employees.size());
	}
	@Test
	public void shouldSaveEmployee() {
		//given
		Employee employee = new Employee();
		Mockito.when(employeeService.save(Mockito.any(Employee.class))).thenReturn(employee);
		//when
		Employee e = employeeService.save(employee);
		//then
		Assert.assertEquals(employee, e);
	}

}
