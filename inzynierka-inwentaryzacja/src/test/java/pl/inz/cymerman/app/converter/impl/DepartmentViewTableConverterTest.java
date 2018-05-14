package pl.inz.cymerman.app.converter.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import junit.framework.Assert;
import pl.inz.cymerman.app.dto.DepartmentTableViewDTO;
import pl.inz.cymerman.app.model.Department;
import pl.inz.cymerman.app.repository.DepartmentRepository;

@RunWith(MockitoJUnitRunner.class)
public class DepartmentViewTableConverterTest {
@Mock
private DepartmentRepository departmentRepository;

@InjectMocks
private DepartmentViewTableConverter converter;

@Test
public void shouldGetDepartmentViewTableConverted() {
	Mockito.when(departmentRepository.findOne(Mockito.anyLong())).thenReturn(new Department());
	Department u = new Department();
	DepartmentTableViewDTO u1 = new DepartmentTableViewDTO();
	u1.setNumberOfWorkers((long) 0);
	DepartmentTableViewDTO u2 = converter.mapTo(u);

	Assert.assertEquals(u1, u2);

}
}
