package pl.inz.cymerman.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.inz.cymerman.app.model.Project;
import pl.inz.cymerman.app.repository.ProjectRepository;
import pl.inz.cymerman.app.service.ProjectService;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService{

	private final ProjectRepository projectRepostiory;
	
	@Autowired
	public ProjectServiceImpl(ProjectRepository projectRepostiory) {
		this.projectRepostiory = projectRepostiory;
	}

	@Override
	public List<Project> findAll() {
		return projectRepostiory.findAll();
	}

	@Override
	public Project findOne(Long id) {
		return projectRepostiory.findOne(id);
	}


}
