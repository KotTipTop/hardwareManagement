package pl.inz.cymerman.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.inz.cymerman.app.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	
}
