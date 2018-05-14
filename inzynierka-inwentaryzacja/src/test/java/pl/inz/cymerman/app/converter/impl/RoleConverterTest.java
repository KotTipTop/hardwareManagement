package pl.inz.cymerman.app.converter.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import junit.framework.Assert;
import pl.inz.cymerman.app.dto.RoleDTO;
import pl.inz.cymerman.app.model.Role;

@RunWith(MockitoJUnitRunner.class)
public class RoleConverterTest {
	@InjectMocks
	private RoleConverter converter;

	@Test
	public void shouldGetRoleConverted() {
		Role u = new Role();
		RoleDTO u1 = new RoleDTO();
		RoleDTO u2 = converter.mapTo(u);

		Assert.assertEquals(u1, u2);

	}
}
