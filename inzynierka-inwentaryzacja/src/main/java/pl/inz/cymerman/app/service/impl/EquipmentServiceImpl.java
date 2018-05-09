package pl.inz.cymerman.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.inz.cymerman.app.dto.EquipmentViewDetailsDTO;
import pl.inz.cymerman.app.model.Category;
import pl.inz.cymerman.app.model.Equipment;
import pl.inz.cymerman.app.repository.EquipmentRepository;
import pl.inz.cymerman.app.repository.LocationRepository;
import pl.inz.cymerman.app.repository.ProjectRepository;
import pl.inz.cymerman.app.service.EquipmentService;

@Transactional
@Service
public class EquipmentServiceImpl implements EquipmentService {
	private final EquipmentRepository equipmentRepository;
	private final ProjectRepository projectRepository;
	private final LocationRepository locationRepository;

	@Autowired
	public EquipmentServiceImpl(EquipmentRepository equipmentRepository, ProjectRepository projectRepository,
			LocationRepository locationRepository) {
		this.equipmentRepository = equipmentRepository;
		this.projectRepository = projectRepository;
		this.locationRepository = locationRepository;
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
		Equipment e = equipmentRepository.findOne(id);
		e.setActive(false);
		equipmentRepository.saveAndFlush(e);

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

	@Override
	public void editEquipment(EquipmentViewDetailsDTO equipment, Equipment e, Category c) {
		e.setCategory(c);
		e.setManufacturer(equipment.getManufacturer());
		e.setModel(equipment.getModel());
		e.setDateOfPurchase(equipment.getDateOfPurchase());
		e.setSerialNumber(equipment.getSerialNumber());
		e.setSoftware(equipment.getSoftware());
		e.setTechnicalParameters(equipment.getTechnicalParameters());
		e.setPeripherials(equipment.getPeripherials());
		e.setPrice(equipment.getPrice());
		e.setWarranty(equipment.getWarranty());
		e.setProject(projectRepository.findOne(equipment.getProject().getId()));
		e.setLocation(locationRepository.findOne(equipment.getLocation().getId()));	
	}

}
