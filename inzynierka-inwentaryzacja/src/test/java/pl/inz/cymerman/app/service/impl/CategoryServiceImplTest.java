package pl.inz.cymerman.app.service.impl;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import pl.inz.cymerman.app.model.Category;
import pl.inz.cymerman.app.repository.CategoryRepository;

@RunWith(MockitoJUnitRunner.class)
public class CategoryServiceImplTest {
	@Mock
	private CategoryRepository repository;

	@InjectMocks
	private CategoryServiceImpl categoryService;
	
	//list
	@Test
	public void shouldGetCategoryList() {
		//given
		Mockito.when(repository.findAll()).thenReturn(Arrays.asList(new Category(), new Category()));
		//when
		List<Category> categories = categoryService.findAll();
		//then
		Assert.assertEquals(2, categories.size());	

	}
	//get by id
	@Test
	public void shouldGetCategoryById() {
		//given
		Mockito.when(repository.findOne(Mockito.anyLong())).thenReturn(new Category(1L, "test"));
		//when
		Category c = categoryService.findOne(1L);
		//then
		Assert.assertEquals(new Category(1L, "test"), c);
	}
}
