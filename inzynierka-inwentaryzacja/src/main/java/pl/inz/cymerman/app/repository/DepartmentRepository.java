package pl.inz.cymerman.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.inz.cymerman.app.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

	@Query("select count(u) from User u join u.department d where d.name = :departmentName")
	long usersByDepartment(@Param("departmentName")String name);
	
}
