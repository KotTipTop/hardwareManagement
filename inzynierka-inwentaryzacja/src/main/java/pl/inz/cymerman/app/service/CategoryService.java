package pl.inz.cymerman.app.service;

import java.util.List;

import pl.inz.cymerman.app.model.Category;

public interface CategoryService {
	List<Category> findAll();
	Category findOne(Long id);
}
