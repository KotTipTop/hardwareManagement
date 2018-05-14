package pl.inz.cymerman.app.converter.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import junit.framework.Assert;
import pl.inz.cymerman.app.dto.DepartmentViewDetailsDTO;
import pl.inz.cymerman.app.model.Department;

@RunWith(MockitoJUnitRunner.class)
public class DepartmentViewDetailsConverterTest {

	@InjectMocks
	private DepartmentViewDetailsConverter converter;

	@Test
	public void shouldGetDepartmentViewDetailsConverted() {
		Department u = new Department();
		DepartmentViewDetailsDTO u1 = new DepartmentViewDetailsDTO();
		DepartmentViewDetailsDTO u2 = converter.mapTo(u);

		Assert.assertEquals(u1, u2);

	}
}
