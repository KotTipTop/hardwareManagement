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

import pl.inz.cymerman.app.model.Role;

import pl.inz.cymerman.app.repository.RoleRepository;

@RunWith(MockitoJUnitRunner.class)
public class RoleServiceImplTest {
	@Mock
	private RoleRepository repository;

	@InjectMocks
	private RoleServiceImpl service;

	// list
	@Test
	public void shouldGetRoleList() {
		// given
		Mockito.when(repository.findAll()).thenReturn(Arrays.asList(new Role(), new Role()));
		// when
		List<Role> roles = service.findAll();
		// then
		Assert.assertEquals(2, roles.size());

	}

	// get by id
	@Test
	public void shouldGetRoleById() {
		// given
		Mockito.when(repository.findOne(Mockito.anyLong())).thenReturn(new Role(1L));
		// when
		Role c = service.findOne(1L);
		// then
		Assert.assertEquals(new Role(1L), c);
	}
}
