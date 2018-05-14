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

import pl.inz.cymerman.app.model.User;
import pl.inz.cymerman.app.repository.UserRepository;


@RunWith(MockitoJUnitRunner.class)
public class UserAdminImplTest {
	@Mock
	private UserRepository repository;

	@InjectMocks
	private UserAdminImpl service;

	// list
	@Test
	public void shouldGetUserList() {
		// given
		Mockito.when(repository.findAll()).thenReturn(Arrays.asList(new User(), new User()));
		// when
		List<User> users = service.findAll();
		// then
		Assert.assertEquals(2, users.size());
	}
	//get one
	@Test
	public void shouldGetUserById() {
		//given
		Mockito.when(repository.findOne(1L)).thenReturn(new User());
		//when
		User d = service.findOne(1L);
		//then
		Assert.assertEquals(new User(), d);
	}
	//save
	@Test
	public void shouldSaveNewUser() {
		//given
		User u = new User();
		Mockito.when(service.save(Mockito.any(User.class))).thenReturn(u);
		//when
		User d = service.save(u);
		//then
		Assert.assertEquals(u, d);
	}
	//delete
	@Test
	public void shouldDeleteUser() {
		//given
		User d = new User(1L,true);
		Mockito.when(repository.findOne(1L)).thenReturn(d);
		User d1 = repository.findOne(1L);
		repository.delete(d1);
		//then
		//times nie działa o co chodzi? 
		Mockito.verify(repository, Mockito.times(1)).findOne(1L);
        Mockito.verify(repository).delete(d);
        Mockito.verifyNoMoreInteractions(repository);
	}
	@Test
	public void shouldGetFalseIsUserWithSameLogin() {
		Mockito.when(repository.isUserWithSameLogin("p.cymerman")).thenReturn(true);
		boolean b1 = repository.isUserWithSameLogin("p.cymerman");
		Assert.assertTrue(b1);
	}
}
