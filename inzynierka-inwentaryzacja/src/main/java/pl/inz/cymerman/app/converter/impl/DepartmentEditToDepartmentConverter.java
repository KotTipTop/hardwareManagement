package pl.inz.cymerman.app.converter.impl;

import org.springframework.stereotype.Service;

import pl.inz.cymerman.app.converter.SimpleObjectConverter;
import pl.inz.cymerman.app.dto.DepartmentEditFormDTO;
import pl.inz.cymerman.app.model.Department;

@Service
public class DepartmentEditToDepartmentConverter implements SimpleObjectConverter<DepartmentEditFormDTO,Department> {

	@Override
	public Department mapTo(DepartmentEditFormDTO from) {
		
		return Department.builder().id(from.getId()).name(from.getName()).build();
	}



}
