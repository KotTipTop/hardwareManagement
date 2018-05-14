package pl.inz.cymerman.app.converter.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import junit.framework.Assert;
import pl.inz.cymerman.app.dto.UserEditFormDTO;
import pl.inz.cymerman.app.model.Department;
import pl.inz.cymerman.app.model.Role;
import pl.inz.cymerman.app.model.User;
import pl.inz.cymerman.app.repository.DepartmentRepository;
import pl.inz.cymerman.app.repository.RoleRepository;

@RunWith(MockitoJUnitRunner.class)
public class UserEditToUserConverterTest {
	@Mock
	private DepartmentRepository departmentRepository;
	
	@Mock
	private RoleRepository roleRepository;
	
	
	@InjectMocks
	private UserEditToUserConverter converter;

	@Test
	public void shouldGetUserEditToUser() {
		Mockito.when(departmentRepository.findOne(Mockito.anyLong())).thenReturn(new Department());
		Mockito.when(roleRepository.findOne(Mockito.anyLong())).thenReturn(new Role());
		UserEditFormDTO u = new UserEditFormDTO();
		User u1 = new User();
		User u2 = converter.mapTo(u);

		Assert.assertEquals(u1, u2);

	}
}
