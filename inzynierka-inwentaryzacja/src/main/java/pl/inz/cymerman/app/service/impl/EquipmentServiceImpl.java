package pl.inz.cymerman.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.inz.cymerman.app.model.Equipment;
import pl.inz.cymerman.app.repository.EquipmentRepository;
import pl.inz.cymerman.app.service.EquipmentService;

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
	public Equipment findOne(Long id) {
		return equipmentRepository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		equipmentRepository.delete(id);

	}

	@Override
	public Equipment save(Equipment model) {
		return equipmentRepository.saveAndFlush(model);
	}

	@Override
	public long countForUserByCategoryName(Long id, String categoryName) {
		return equipmentRepository.countForUserByCategoryName(id, categoryName);
	}

	@Override
	public List<Equipment> EquipmentForUserByCategoryName(Long id, String categoryName) {
		return equipmentRepository.EquipmentForUserByCategoryName(id, categoryName);
	}

}
