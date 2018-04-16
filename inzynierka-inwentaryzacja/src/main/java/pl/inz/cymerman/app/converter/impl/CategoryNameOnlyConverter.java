package pl.inz.cymerman.app.converter.impl;

import org.springframework.stereotype.Service;

import pl.inz.cymerman.app.converter.SimpleObjectConverter;
import pl.inz.cymerman.app.dto.CategoryNameOnlyDTO;
import pl.inz.cymerman.app.model.Category;

@Service
public class CategoryNameOnlyConverter implements SimpleObjectConverter<Category, CategoryNameOnlyDTO>{

	@Override
	public CategoryNameOnlyDTO mapTo(Category from) {
		return CategoryNameOnlyDTO.builder().id(from.getId()).name(from.getName()).build();
	}

}
