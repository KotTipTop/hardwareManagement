package pl.inz.cymerman.app.converter.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import junit.framework.Assert;
import pl.inz.cymerman.app.dto.UserViewDetailsDTO;
import pl.inz.cymerman.app.model.User;

@RunWith(MockitoJUnitRunner.class)
public class UserDetailsViewConverterTest {
	@InjectMocks
	private UserDetailsViewConverter converter;

	@Test
	public void shouldGetUserDetailsViewConverted() {
		User u = new User();
		UserViewDetailsDTO u1 = new UserViewDetailsDTO();
		UserViewDetailsDTO u2 = converter.mapTo(u);

		Assert.assertEquals(u1, u2);

	}
}
