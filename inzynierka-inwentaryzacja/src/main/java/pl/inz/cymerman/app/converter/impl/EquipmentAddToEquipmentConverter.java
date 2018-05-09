package pl.inz.cymerman.app.converter.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.inz.cymerman.app.converter.SimpleObjectConverter;
import pl.inz.cymerman.app.dto.EquipmentAddFormDTO;
import pl.inz.cymerman.app.model.Equipment;
import pl.inz.cymerman.app.repository.CategoryRepository;
import pl.inz.cymerman.app.repository.LocationRepository;
import pl.inz.cymerman.app.repository.ProjectRepository;

@Service
public class EquipmentAddToEquipmentConverter implements SimpleObjectConverter<EquipmentAddFormDTO, Equipment> {

	private final CategoryRepository categoryRepository;
	private final ProjectRepository projectRepository;
	private final LocationRepository locationRepository;

	@Autowired
	public EquipmentAddToEquipmentConverter(CategoryRepository categoryRepository, ProjectRepository projectRepository, LocationRepository locationRepository) {
		this.categoryRepository = categoryRepository;
		this.projectRepository = projectRepository;
		this.locationRepository = locationRepository;
	}

	@Override
	public Equipment mapTo(EquipmentAddFormDTO from) {
		return Equipment.builder()//
				.category(categoryRepository.findOne(from.getCategoryId()))//
				.manufacturer(from.getManufacturer())//
				.model(from.getModel())//
				.serialNumber(from.getSerialNumber())//
				.software(from.getSoftware())//
				.technicalParameters(from.getTechnicalParameters())//
				.peripherials(from.getPeripherials())//
				.price(from.getPrice())//
				.project(projectRepository.findOne(from.getProjectId()))//
				.location(locationRepository.findOne(from.getLocationId()))//
				.warranty(from.getWarranty())
				.active(true)
				.build();
	}

}
