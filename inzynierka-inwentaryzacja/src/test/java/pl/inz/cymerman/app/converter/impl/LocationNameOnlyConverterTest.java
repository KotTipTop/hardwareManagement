package pl.inz.cymerman.app.converter.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import junit.framework.Assert;
import pl.inz.cymerman.app.dto.LocationNameOnlyDTO;
import pl.inz.cymerman.app.model.Location;

@RunWith(MockitoJUnitRunner.class)
public class LocationNameOnlyConverterTest {

	@InjectMocks
	private LocationNameOnlyConverter converter;

	@Test
	public void shouldGetLocationNameOnlyConverted() {
		Location u = new Location();
		LocationNameOnlyDTO u1 = new LocationNameOnlyDTO();
		LocationNameOnlyDTO u2 = converter.mapTo(u);

		Assert.assertEquals(u1, u2);

	}
}
