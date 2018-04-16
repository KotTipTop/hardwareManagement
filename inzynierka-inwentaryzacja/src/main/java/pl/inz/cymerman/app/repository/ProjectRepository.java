package pl.inz.cymerman.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.inz.cymerman.app.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long>{

}
