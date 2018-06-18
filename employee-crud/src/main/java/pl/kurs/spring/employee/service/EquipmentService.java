package pl.kurs.spring.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import pl.kurs.spring.employee.model.Equipment;

public interface EquipmentService {
	List<Equipment> findAll();

	Optional<Equipment> findOne(Long id);

	Equipment save(Equipment model);
	
	void delete(Long id);	
	Page<Equipment> findAllAcitves(Pageable pageable, String query);
	Optional<Equipment> findOneActive(Long id);
}
