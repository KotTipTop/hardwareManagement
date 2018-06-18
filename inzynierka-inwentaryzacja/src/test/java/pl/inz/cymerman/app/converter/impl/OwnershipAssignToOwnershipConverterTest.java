package pl.inz.cymerman.app.converter.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;


import pl.inz.cymerman.app.dto.OwnershipAssignFormDTO;
import pl.inz.cymerman.app.model.Equipment;
import pl.inz.cymerman.app.model.Location;
import pl.inz.cymerman.app.model.Ownership;
import pl.inz.cymerman.app.model.Project;
import pl.inz.cymerman.app.model.User;
import pl.inz.cymerman.app.repository.EquipmentRepository;
import pl.inz.cymerman.app.repository.LocationRepository;
import pl.inz.cymerman.app.repository.ProjectRepository;
import pl.inz.cymerman.app.repository.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class OwnershipAssignToOwnershipConverterTest {

	@Mock
	private EquipmentRepository equipmentRepository;
	@Mock
	private ProjectRepository projectRepository;

	@Mock
	private LocationRepository locationRepository;

	@Mock
	private UserRepository userRepository;

	@InjectMocks
	private OwnershipAssignToOwnershipConverter converter;

	@Test
	public void shouldGetOwnershipAssignToOwnershipConverted() {
		Mockito.when(userRepository.findOne(Mockito.anyLong())).thenReturn(new User());
		Mockito.when(projectRepository.findOne(Mockito.anyLong())).thenReturn(new Project());
		Mockito.when(locationRepository.findOne(Mockito.anyLong())).thenReturn(new Location());
		Mockito.when(equipmentRepository.findOne(Mockito.anyLong())).thenReturn(new Equipment());
		OwnershipAssignFormDTO u = new OwnershipAssignFormDTO();
		Ownership u1 = new Ownership();
		Ownership u2 = converter.mapTo(u);

		Assert.assertEquals(u1, u2);

	}
}
