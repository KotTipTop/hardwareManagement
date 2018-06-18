package pl.kurs.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.kurs.java.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>  {

}
