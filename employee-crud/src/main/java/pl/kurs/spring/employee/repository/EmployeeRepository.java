package pl.kurs.spring.employee.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.kurs.spring.employee.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@Query("select distinct e from Employee e join e.equipment eq where e.active = true and "
			+"upper(e.name) like %:val% or "
			+"upper(e.surname) like %:val% or "
			+"upper(e.salary) like %:val% or "
			+"upper(eq.name) like %:val% or "
			+"upper(e.position) like %:val%")
	Page<Employee> findAllActive(Pageable pageable,@Param("val") String query);

	@Query("select e from Employee e where e.id = :empId and e.active = true")
	Optional<Employee> findOneActive(@Param("empId") Long id);

}
