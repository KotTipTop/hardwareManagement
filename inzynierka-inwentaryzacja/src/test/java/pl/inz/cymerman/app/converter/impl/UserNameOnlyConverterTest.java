package pl.inz.cymerman.app.converter.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import junit.framework.Assert;
import pl.inz.cymerman.app.dto.UserNameOnlyDTO;
import pl.inz.cymerman.app.model.User;

@RunWith(MockitoJUnitRunner.class)
public class UserNameOnlyConverterTest {
	@InjectMocks
	private UserNameOnlyConverter converter;

	@Test
	public void shouldGetUserNameOnlyDTOConverted() {
		User u = new User();
		UserNameOnlyDTO u1 = new UserNameOnlyDTO();
		u1.setFullName(null+" "+null);
		UserNameOnlyDTO u2 = converter.mapTo(u);

		Assert.assertEquals(u1, u2);

	}
}
