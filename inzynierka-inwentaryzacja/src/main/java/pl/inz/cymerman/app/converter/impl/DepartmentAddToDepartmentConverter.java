package pl.inz.cymerman.app.converter.impl;

import org.springframework.stereotype.Service;

import pl.inz.cymerman.app.converter.SimpleObjectConverter;
import pl.inz.cymerman.app.dto.DepartmentAddFormDTO;
import pl.inz.cymerman.app.model.Department;

@Service
public class DepartmentAddToDepartmentConverter implements SimpleObjectConverter<DepartmentAddFormDTO, Department> {

	@Override
	public Department mapTo(DepartmentAddFormDTO from) {
		return Department.builder().name(from.getName()).active(true).build();
	}


}
