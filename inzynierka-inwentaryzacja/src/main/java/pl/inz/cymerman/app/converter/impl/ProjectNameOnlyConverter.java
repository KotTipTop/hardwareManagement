package pl.inz.cymerman.app.converter.impl;

import org.springframework.stereotype.Service;

import pl.inz.cymerman.app.converter.SimpleObjectConverter;
import pl.inz.cymerman.app.dto.ProjectNameOnlyDTO;
import pl.inz.cymerman.app.model.Project;
@Service
public class ProjectNameOnlyConverter implements SimpleObjectConverter<Project, ProjectNameOnlyDTO> {
	@Override
	public ProjectNameOnlyDTO mapTo(Project from) {
		return ProjectNameOnlyDTO.builder().id(from.getId()!=null ? from.getId():null).name(from.getName()!=null ? from.getName():null).build();
	}

}
