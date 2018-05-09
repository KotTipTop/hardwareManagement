package pl.inz.cymerman.app.service.impl;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import pl.inz.cymerman.app.model.Location;
import pl.inz.cymerman.app.repository.LocationRepository;



public class LocationServiceImplTest {
	@Mock
	private LocationRepository repository;

	@InjectMocks
	private LocationServiceImpl locationService;
	
	//list
	@Test
	public void shouldGetCategoryList() {
		//given
		Mockito.when(repository.findAll()).thenReturn(Arrays.asList(new Location(), new Location()));
		//when
		List<Location> locations = locationService.findAll();
		//then
		Assert.assertEquals(2, locations.size());	

	}
	//get by id
	@Test
	public void shouldGetCategoryById() {
		//given
		Mockito.when(repository.findOne(Mockito.anyLong())).thenReturn(new Location(1L));
		//when
		Location c = locationService.findOne(1L);
		//then
		Assert.assertEquals(new Location(1L), c);
	}
}
