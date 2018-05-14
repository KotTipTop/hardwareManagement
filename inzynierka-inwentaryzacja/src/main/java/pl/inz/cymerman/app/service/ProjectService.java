package pl.inz.cymerman.app.service;

import java.util.List;

import pl.inz.cymerman.app.model.Project;

public interface ProjectService {
	List<Project> findAll();
	Project findOne(Long id);
}
