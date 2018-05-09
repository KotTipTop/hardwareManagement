package pl.inz.cymerman.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.inz.cymerman.app.model.Department;
import pl.inz.cymerman.app.repository.DepartmentRepository;
import pl.inz.cymerman.app.service.DepartmentService;

@Transactional
@Service
public class DepartmentServiceImpl implements DepartmentService {

	private final DepartmentRepository departmentRepository;
	
	
	@Autowired
	public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
		this.departmentRepository = departmentRepository;
	}

	@Override
	public List<Department> findAll() {

		return departmentRepository.findAll();
	}

	@Override
	public Department findOne(Long id) {
		return departmentRepository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		Department d =departmentRepository.findOne(id);
		d.setActive(false);
		departmentRepository.saveAndFlush(d);
		
	}

	@Override
	public Department save(Department model) {
		return departmentRepository.saveAndFlush(model);
	}

	@Override
	public long userByDepartmentName(String name) {
		return departmentRepository.usersByDepartment(name);
	}

	
}
