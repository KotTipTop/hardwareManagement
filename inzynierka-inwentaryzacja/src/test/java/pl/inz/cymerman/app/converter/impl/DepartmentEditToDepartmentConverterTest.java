package pl.inz.cymerman.app.converter.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import junit.framework.Assert;
import pl.inz.cymerman.app.dto.DepartmentEditFormDTO;
import pl.inz.cymerman.app.model.Department;

@RunWith(MockitoJUnitRunner.class)
public class DepartmentEditToDepartmentConverterTest {

	@InjectMocks
	private DepartmentEditToDepartmentConverter converter;

	@Test
	public void shouldGetDepartmentEditToDepartmentConverted() {
		DepartmentEditFormDTO u = new DepartmentEditFormDTO();
		Department u1 = new Department();
		Department u2 = converter.mapTo(u);

		Assert.assertEquals(u2, u1);

	}
}
