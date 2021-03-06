package pl.inz.cymerman.app.service;

import java.util.List;

import pl.inz.cymerman.app.dto.EquipmentViewDetailsDTO;
import pl.inz.cymerman.app.model.Category;
import pl.inz.cymerman.app.model.Equipment;

public interface EquipmentService {
	List<Equipment> findAll();
	Equipment findOne(Long id);
	void delete(Long id);
	Equipment save(Equipment model);
	long countForUserByCategoryName(Long id, String string);
	List<Equipment> EquipmentForUserByCategoryName(Long id, String string);
	void editEquipment(EquipmentViewDetailsDTO equipment, Equipment e, Category c);
	
}
