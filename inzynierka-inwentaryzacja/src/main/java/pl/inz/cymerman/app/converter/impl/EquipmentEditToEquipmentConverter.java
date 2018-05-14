package pl.inz.cymerman.app.converter.impl;

import org.springframework.beans.factory.annotation.Autowired;

import pl.inz.cymerman.app.converter.SimpleObjectConverter;
import pl.inz.cymerman.app.dto.EquipmentEditFormDTO;
import pl.inz.cymerman.app.model.Equipment;
import pl.inz.cymerman.app.repository.CategoryRepository;
import pl.inz.cymerman.app.repository.LocationRepository;
import pl.inz.cymerman.app.repository.ProjectRepository;

public class EquipmentEditToEquipmentConverter implements SimpleObjectConverter<EquipmentEditFormDTO, Equipment> {

	private final CategoryRepository categoryRepository;
	private final ProjectRepository projectRepository;
	private final LocationRepository locationRepository;

	@Autowired
	public EquipmentEditToEquipmentConverter(CategoryRepository categoryRepository, ProjectRepository projectRepository, LocationRepository locationRepository) {
		this.categoryRepository = categoryRepository;
		this.projectRepository = projectRepository;
		this.locationRepository = locationRepository;
	}
	
	@Override
	public Equipment mapTo(EquipmentEditFormDTO from) {

		return Equipment.builder()//
				.category(from.getCategoryId()!=null?categoryRepository.findOne(from.getCategoryId()):null)//
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
				.build();
	}

}
