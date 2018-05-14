package pl.inz.cymerman.app.converter.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import junit.framework.Assert;
import pl.inz.cymerman.app.dto.UserTableViewDTO;
import pl.inz.cymerman.app.model.User;

@RunWith(MockitoJUnitRunner.class)
public class UserTableViewConverterTest {
	@InjectMocks
	private UserTableViewConverter converter;

	@Test
	public void shouldGetUserTableViewConverted() {
		User u = new User();
		UserTableViewDTO u1 = new UserTableViewDTO();
		u1.setFullName(null+" "+null);
		UserTableViewDTO u2 = converter.mapTo(u);

		Assert.assertEquals(u1, u2);

	}
}
