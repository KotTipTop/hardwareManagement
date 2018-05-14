package pl.inz.cymerman.app.converter.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import junit.framework.Assert;
import pl.inz.cymerman.app.dto.UserDetailsAdminPageInfoDTO;
import pl.inz.cymerman.app.model.User;

@RunWith(MockitoJUnitRunner.class)
public class UserAdminPageConverterTest {
	
@Mock
private RoleConverter roleConverter;

@InjectMocks
private UserAdminPageConverter converter;

@Test
public void shouldGetUserDetailsForAdminPageInfo() {
	User u = new User();
	UserDetailsAdminPageInfoDTO u1 = new UserDetailsAdminPageInfoDTO();
	UserDetailsAdminPageInfoDTO u2 = converter.mapTo(u);
	
	Assert.assertEquals(u1, u2);
		
}
}
