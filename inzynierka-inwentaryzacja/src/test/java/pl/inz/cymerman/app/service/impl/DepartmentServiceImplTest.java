package pl.inz.cymerman.app.service.impl;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import pl.inz.cymerman.app.model.Department;
import pl.inz.cymerman.app.repository.DepartmentRepository;


@RunWith(MockitoJUnitRunner.class)
public class DepartmentServiceImplTest {
	@Mock
	private DepartmentRepository repository;

	@InjectMocks
	private DepartmentServiceImpl departmentService;

	// list
	@Test
	public void shouldGetDepartmentList() {
		// given
		Mockito.when(repository.findAll()).thenReturn(Arrays.asList(new Department(), new Department()));
		// when
		List<Department> departments = departmentService.findAll();
		// then
		Assert.assertEquals(2, departments.size());
	}
	//get one
	@Test
	public void shouldGetDepartmentById() {
		//given
		Mockito.when(repository.findOne(Mockito.anyLong())).thenReturn(new Department(1L, "test",null,true));
		//when
		Department d = departmentService.findOne(1L);
		//then
		Assert.assertEquals(new Department(1L, "test",null,true), d);
	}
	//save
	@Test
	public void shouldSaveNewDepartment() {
		//given
		Department departmentOne = new Department();
		Mockito.when(departmentService.save(Mockito.any(Department.class))).thenReturn(departmentOne);
		//when
		Department d = departmentService.save(departmentOne);
		//then
		Assert.assertEquals(departmentOne, d);
	}
	//delete
	@Test
	public void shouldDeleteDepartment() {
		//given
		Department d = new Department(1L, "test",null,true);
		Mockito.when(repository.findOne(Mockito.anyLong())).thenReturn(d);
		
		//then
		//times nie działa o co chodzi? 
		Mockito.verify(departmentService).findOne(1L);
        Mockito.verify(repository).delete(d);
        Mockito.verifyNoMoreInteractions(repository);
	}

}
