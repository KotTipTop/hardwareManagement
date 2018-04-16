package pl.inz.cymerman.app.converter.impl;

import org.springframework.stereotype.Service;

import pl.inz.cymerman.app.converter.SimpleObjectConverter;
import pl.inz.cymerman.app.dto.DepartmentViewDetailsDTO;
import pl.inz.cymerman.app.model.Department;

@Service
public class DepartmentViewDetailsConverter implements SimpleObjectConverter<Department, DepartmentViewDetailsDTO> {

	@Override
	public DepartmentViewDetailsDTO mapTo(Department from) {
		
		return DepartmentViewDetailsDTO.builder().id(from.getId()).name(from.getName()).build();
	}

}
