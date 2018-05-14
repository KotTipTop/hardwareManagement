package pl.inz.cymerman.app.converter.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import junit.framework.Assert;
import pl.inz.cymerman.app.dto.EquipmentTableViewDTO;
import pl.inz.cymerman.app.dto.EquipmentViewDetailsDTO;
import pl.inz.cymerman.app.model.Equipment;

@RunWith(MockitoJUnitRunner.class)
public class EquipmentTableViewConverterTest {
	@InjectMocks
	private EquipmentTableViewConverter converter;

	@Test
	public void shouldGetEquipmentTableViewConverted() {
		Equipment u = new Equipment();
		EquipmentTableViewDTO u1 = new EquipmentTableViewDTO();
		EquipmentTableViewDTO u2 = converter.mapTo(u);

		Assert.assertEquals(u1, u2);

	}
}
