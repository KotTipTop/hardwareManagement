package pl.inz.cymerman.app.service.impl;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import pl.inz.cymerman.app.model.Ownership;
import pl.inz.cymerman.app.repository.OwnershipRepository;


public class OwnershipServiceImplTest {

	@Mock
	private OwnershipRepository repository;

	@InjectMocks
	private OwnershipServiceImpl service;

	// list
	@Test
	public void shouldGetOwnerhipList() {
		// given
		Mockito.when(repository.findAll()).thenReturn(Arrays.asList(new Ownership(), new Ownership()));
		// when
		List<Ownership> ownerships = service.findAll();
		// then
		Assert.assertEquals(2, ownerships.size());
	}
	//get one
	@Test
	public void shouldGetDepartmentById() {
		//given
		Mockito.when(repository.findOne(Mockito.anyLong())).thenReturn(new Ownership(1L));
		//when
		Ownership d = service.findOne(1L);
		//then
		Assert.assertEquals(new Ownership(1L), d);
	}
	//save
	@Test
	public void shouldSaveNewOwnership() {
		//given
		Ownership ownershipOne = new Ownership();
		Mockito.when(service.save(Mockito.any(Ownership.class))).thenReturn(ownershipOne);
		//when
		Ownership d = service.save(ownershipOne);
		//then
		Assert.assertEquals(service, d);
	}
}
