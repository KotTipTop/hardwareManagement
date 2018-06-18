package pl.kurs.spring.employee.converter.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.kurs.spring.converter.SimpleObjectConverter;
import pl.kurs.spring.employee.command.EquipmentEditCommand;
import pl.kurs.spring.employee.model.Equipment;
import pl.kurs.spring.employee.repository.EmployeeRepository;

@Service
public class EquipmentEditCommandToEquipmentConverter implements SimpleObjectConverter<EquipmentEditCommand, Equipment>{
	private final EmployeeRepository employeeRepository;
	
	@Autowired
	public EquipmentEditCommandToEquipmentConverter(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}


	@Override
	public Equipment mapTo(EquipmentEditCommand from) {

		return Equipment.builder()
				.id(from.getId())
				.name(from.getName())
				.category(from.getCategory())
				.price(from.getPrice())
				.active(from.isActive())
				.owner(employeeRepository.findOne(from.getOwnerId()))
				.build();
	}

}
