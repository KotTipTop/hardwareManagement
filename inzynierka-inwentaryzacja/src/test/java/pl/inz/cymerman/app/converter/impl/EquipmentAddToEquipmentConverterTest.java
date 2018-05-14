package pl.inz.cymerman.app.converter.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import junit.framework.Assert;
import pl.inz.cymerman.app.dto.EquipmentAddFormDTO;
import pl.inz.cymerman.app.model.Category;
import pl.inz.cymerman.app.model.Equipment;
import pl.inz.cymerman.app.model.Location;
import pl.inz.cymerman.app.model.Project;
import pl.inz.cymerman.app.repository.CategoryRepository;
import pl.inz.cymerman.app.repository.LocationRepository;
import pl.inz.cymerman.app.repository.ProjectRepository;

@RunWith(MockitoJUnitRunner.class)
public class EquipmentAddToEquipmentConverterTest {
	@Mock
	private CategoryRepository categoryRepository;
	@Mock
	private ProjectRepository projectRepository;
	
	@Mock
	private LocationRepository locationRepository;
	
	
	@InjectMocks
	private EquipmentAddToEquipmentConverter converter;

	@Test
	public void shouldGetEquipmentAddToEquipmentConverted() {
		Mockito.when(categoryRepository.findOne(Mockito.anyLong())).thenReturn(new Category());
		Mockito.when(projectRepository.findOne(Mockito.anyLong())).thenReturn(new Project());
		Mockito.when(locationRepository.findOne(Mockito.anyLong())).thenReturn(new Location());
		EquipmentAddFormDTO u = new EquipmentAddFormDTO();
		Equipment u1 = new Equipment();
		u1.setActive(true);
		Equipment u2 = converter.mapTo(u);

		Assert.assertEquals(u1, u2);

	}
}
