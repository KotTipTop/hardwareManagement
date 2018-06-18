package pl.kurs.spring.employee.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import pl.kurs.spring.employee.model.Equipment;
import pl.kurs.spring.employee.repository.EquipmentRepository;
import pl.kurs.spring.employee.service.EquipmentService;

@Transactional
@Service
public class EquipmentServiceImpl implements EquipmentService {
	private final EquipmentRepository equipmentRepository;

	@Autowired
	public EquipmentServiceImpl(EquipmentRepository equipmentRepository) {
		this.equipmentRepository = equipmentRepository;
	}

	@Override
	public List<Equipment> findAll() {
		return equipmentRepository.findAll();
	}

	@Override
	public Optional<Equipment> findOne(Long id) {
		return Optional.ofNullable(equipmentRepository.findOne(id));
	}

	@Override
	public Equipment save(Equipment model) {
		return equipmentRepository.saveAndFlush(model);
	}

	@Override
	public void delete(Long id) {
		Equipment e = equipmentRepository.findOne(id);
		e.setActive(false);
		equipmentRepository.saveAndFlush(e);

	}

	@Override
	public Page<Equipment> findAllAcitves(Pageable pageable, String query) {
		return equipmentRepository.findAllActive(pageable,Optional.ofNullable(query).map(String::toUpperCase).orElse(""));
	}

	@Override
	public Optional<Equipment> findOneActive(Long id) {
		return equipmentRepository.findOneActive(id);
	}

}
