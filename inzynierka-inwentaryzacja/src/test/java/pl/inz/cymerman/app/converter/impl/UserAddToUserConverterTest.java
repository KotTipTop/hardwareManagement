package pl.inz.cymerman.app.converter.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import pl.inz.cymerman.app.dto.UserAddFormDTO;
import pl.inz.cymerman.app.model.Department;
import pl.inz.cymerman.app.repository.DepartmentRepository;
import pl.inz.cymerman.app.repository.RoleRepository;

@RunWith(MockitoJUnitRunner.class)
public class UserAddToUserConverterTest {
	@Mock
	private DepartmentRepository departmentRepository;
	@Mock
	private RoleRepository roleRepository;
	
	@InjectMocks
	private UserAddToUserConverter userAddToUserConverter;
	
	@Test
	public void shouldGetConvertedUser() {
		Mockito.when(departmentRepository.findOne(Mockito.anyLong())).thenReturn(new Department());
		Mockito.when(roleRepository.findOne(Mockito.anyLong()));
	}
}
