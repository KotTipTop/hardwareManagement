package pl.inz.cymerman.app.converter.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import junit.framework.Assert;
import pl.inz.cymerman.app.dto.OwnershipEquipmentHistoryDetailsDTO;
import pl.inz.cymerman.app.model.Ownership;

@RunWith(MockitoJUnitRunner.class)
public class OwnershipEquipmentHistoryDetailsConverterTest {
	@InjectMocks
	private OwnershipEquipmentHistoryDetailsConverter converter;

	@Test
	public void shouldGetOwnershipEquipmentHistoryDetailsConverted() {
		Ownership u = new Ownership();
		OwnershipEquipmentHistoryDetailsDTO u1 = new OwnershipEquipmentHistoryDetailsDTO();
		OwnershipEquipmentHistoryDetailsDTO u2 = converter.mapTo(u);

		Assert.assertEquals(u1, u2);

	}
}
