package pl.inz.cymerman.app.converter.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import junit.framework.Assert;
import pl.inz.cymerman.app.dto.ProjectNameOnlyDTO;
import pl.inz.cymerman.app.model.Project;

@RunWith(MockitoJUnitRunner.class)
public class ProjectNameOnlyConverterTest {
	@InjectMocks
	private ProjectNameOnlyConverter converter;

	@Test
	public void shouldGetProjectNameOnlyConverted() {
		Project u = new Project();
		ProjectNameOnlyDTO u1 = new ProjectNameOnlyDTO();
		ProjectNameOnlyDTO u2 = converter.mapTo(u);

		Assert.assertEquals(u1, u2);

	}
}
