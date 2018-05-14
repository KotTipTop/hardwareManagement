package pl.inz.cymerman.app.converter.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import junit.framework.Assert;
import pl.inz.cymerman.app.dto.EquipmentViewDetailsDTO;
import pl.inz.cymerman.app.model.Equipment;

@RunWith(MockitoJUnitRunner.class)
public class EquipmentDetailsViewConverterTest {

	@InjectMocks
	private EquipmentDetailsViewConverter converter;

	@Test
	public void shouldGetEquipmentDetailsViewConverted() {
		Equipment u = new Equipment();
		EquipmentViewDetailsDTO u1 = new EquipmentViewDetailsDTO();
		EquipmentViewDetailsDTO u2 = converter.mapTo(u);

		Assert.assertEquals(u1, u2);

	}
}
