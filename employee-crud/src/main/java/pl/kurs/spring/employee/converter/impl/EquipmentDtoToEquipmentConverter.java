package pl.kurs.spring.employee.converter.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.kurs.spring.converter.SimpleObjectConverter;
import pl.kurs.spring.employee.dto.EquipmentDTO;
import pl.kurs.spring.employee.model.Equipment;
import pl.kurs.spring.employee.repository.EmployeeRepository;

@Service
public class EquipmentDtoToEquipmentConverter implements SimpleObjectConverter<EquipmentDTO, Equipment> {

	private final EmployeeRepository employeeRepository;
	
	@Autowired
	public EquipmentDtoToEquipmentConverter(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Equipment mapTo(EquipmentDTO from) {
		return Equipment.builder()
				.name(from.getName())
				.category(from.getCategory())
				.price(from.getPrice())
				.owner(employeeRepository.findOne(from.getOwnerId()))
				.active(from.isActive()).build();
	}

}
