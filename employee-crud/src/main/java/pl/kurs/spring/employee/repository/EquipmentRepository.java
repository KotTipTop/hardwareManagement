package pl.kurs.spring.employee.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.kurs.spring.employee.model.Equipment;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {

	@Query("select distinct e from Equipment e join e.owner user where e.active = true and "
	+"upper(e.name) like %:val% or "
	+"upper(e.category) like %:val% or "
	+"upper(e.price) like %:val% or "
	+"upper(user.name) like %:val%")
	Page<Equipment> findAllActive(Pageable pageable, @Param("val") String query);

	@Query("select e from Equipment e where e.id = :eId and e.active = true")
	Optional<Equipment> findOneActive(@Param("eId") Long id);
}
