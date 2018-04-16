package pl.inz.cymerman.app.converter.impl;

import org.springframework.stereotype.Service;

import pl.inz.cymerman.app.converter.SimpleObjectConverter;
import pl.inz.cymerman.app.dto.DepartmentTableViewDTO;
import pl.inz.cymerman.app.model.Department;
import pl.inz.cymerman.app.repository.DepartmentRepository;

@Service
public class DepartmentViewTableConverter implements SimpleObjectConverter<Department, DepartmentTableViewDTO> {
	private final DepartmentRepository departmentRepository;
	
	
	public DepartmentViewTableConverter(DepartmentRepository departmentRepository) {
		this.departmentRepository = departmentRepository;
	}


	@Override
	public DepartmentTableViewDTO mapTo(Department from) {
		return DepartmentTableViewDTO.builder()
				.id(from.getId()).Name(from.getName()).numberOfWorkers(departmentRepository.usersByDepartment(from.getName())).build();
	}

}
