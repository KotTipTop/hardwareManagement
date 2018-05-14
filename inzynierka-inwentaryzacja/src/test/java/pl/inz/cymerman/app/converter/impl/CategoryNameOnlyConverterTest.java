package pl.inz.cymerman.app.converter.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import junit.framework.Assert;
import pl.inz.cymerman.app.dto.CategoryNameOnlyDTO;
import pl.inz.cymerman.app.model.Category;

@RunWith(MockitoJUnitRunner.class)
public class CategoryNameOnlyConverterTest {

	@InjectMocks
	private CategoryNameOnlyConverter converter;

	@Test
	public void shouldGetCategoryNameOnlyConverted() {
		Category u = new Category();
		CategoryNameOnlyDTO u1 = new CategoryNameOnlyDTO();
		CategoryNameOnlyDTO u2 = converter.mapTo(u);

		Assert.assertEquals(u1, u2);

	}
}
