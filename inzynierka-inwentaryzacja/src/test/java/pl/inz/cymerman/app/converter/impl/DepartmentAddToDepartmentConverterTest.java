package pl.inz.cymerman.app.converter.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import junit.framework.Assert;
import pl.inz.cymerman.app.dto.DepartmentAddFormDTO;
import pl.inz.cymerman.app.model.Department;

@RunWith(MockitoJUnitRunner.class)
public class DepartmentAddToDepartmentConverterTest {

	@InjectMocks
	private DepartmentAddToDepartmentConverter converter;

	@Test
	public void shouldGetDepartmentAddToDepartmentConverted() {
		DepartmentAddFormDTO u = new DepartmentAddFormDTO();
		Department u1 = new Department();
		u1.setActive(true);
		Department u2 = converter.mapTo(u);

		Assert.assertEquals(u1, u2);

	}
}
