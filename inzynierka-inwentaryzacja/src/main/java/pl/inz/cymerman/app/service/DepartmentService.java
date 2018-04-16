package pl.inz.cymerman.app.service;

import java.util.List;

import pl.inz.cymerman.app.model.Department;

public interface DepartmentService {
	List<Department> findAll();
	Department findOne(Long id);
	void delete(Long id);
	Department save(Department model);
	long userByDepartmentName(String name);
}
