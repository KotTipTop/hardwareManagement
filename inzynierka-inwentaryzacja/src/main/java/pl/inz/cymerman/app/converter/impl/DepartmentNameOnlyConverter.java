package pl.inz.cymerman.app.converter.impl;

import org.springframework.stereotype.Service;

import pl.inz.cymerman.app.converter.SimpleObjectConverter;
import pl.inz.cymerman.app.dto.DepartmentNameOnlyDTO;
import pl.inz.cymerman.app.model.Department;

@Service
public class DepartmentNameOnlyConverter implements SimpleObjectConverter<Department, DepartmentNameOnlyDTO> {
	@Override
	public DepartmentNameOnlyDTO mapTo(Department from) {
		return DepartmentNameOnlyDTO.builder().id(from.getId()).name(from.getName()).build();
	}
}
