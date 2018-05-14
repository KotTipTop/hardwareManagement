package pl.inz.cymerman.app.converter.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import junit.framework.Assert;
import pl.inz.cymerman.app.dto.DepartmentNameOnlyDTO;
import pl.inz.cymerman.app.model.Department;

@RunWith(MockitoJUnitRunner.class)
public class DepartmentNameOnlyConverterTest {
	@InjectMocks
	private DepartmentNameOnlyConverter converter;

	@Test
	public void shouldGetDepartmentNameOnlyConverted() {
		Department u = new Department();
		DepartmentNameOnlyDTO u1 = new DepartmentNameOnlyDTO();
		DepartmentNameOnlyDTO u2 = converter.mapTo(u);

		Assert.assertEquals(u1, u2);

	}
}
