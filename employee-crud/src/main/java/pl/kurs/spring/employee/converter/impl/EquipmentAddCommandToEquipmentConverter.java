package pl.kurs.spring.employee.converter.impl;

import org.springframework.stereotype.Service;

import pl.kurs.spring.converter.SimpleObjectConverter;
import pl.kurs.spring.employee.command.EquipmentAddCommand;
import pl.kurs.spring.employee.model.Equipment;

@Service
public class EquipmentAddCommandToEquipmentConverter implements SimpleObjectConverter<EquipmentAddCommand, Equipment> {


	@Override
	public Equipment mapTo(EquipmentAddCommand from) {
		return Equipment.builder().name(from.getName()).category(from.getCategory()).price(from.getPrice()).active(from.isActive()).build();
	}

}
