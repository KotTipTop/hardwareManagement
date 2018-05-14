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

import pl.inz.cymerman.app.model.Location;
import pl.inz.cymerman.app.model.Project;
import pl.inz.cymerman.app.repository.LocationRepository;
import pl.inz.cymerman.app.repository.ProjectRepository;

@RunWith(MockitoJUnitRunner.class)
public class ProjectServicesImplTest {
	@Mock
	private ProjectRepository repository;

	@InjectMocks
	private ProjectServiceImpl service;
	
	//list
	@Test
	public void shouldGetProjectList() {
		//given
		Mockito.when(repository.findAll()).thenReturn(Arrays.asList(new Project(), new Project()));
		//when
		List<Project> projects = service.findAll();
		//then
		Assert.assertEquals(2, projects.size());	

	}
	//get by id
	@Test
	public void shouldGetProjectById() {
		//given
		Mockito.when(repository.findOne(Mockito.anyLong())).thenReturn(new Project(1L));
		//when
		Project c = service.findOne(1L);
		//then
		Assert.assertEquals(new Project(1L), c);
	}
}
