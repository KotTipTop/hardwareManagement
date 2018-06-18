package pl.kurs.spring.employee.converter.impl;

import org.springframework.stereotype.Service;

import pl.kurs.spring.converter.SimpleObjectConverter;
import pl.kurs.spring.employee.dto.EquipmentDTO;
import pl.kurs.spring.employee.model.Equipment;

@Service
public class EquipmentToEquipmentDtoConverter implements SimpleObjectConverter<Equipment, EquipmentDTO> {

	@Override
	public EquipmentDTO mapTo(Equipment from) {
		return EquipmentDTO.builder()
				.id(from.getId())
				.name(from.getName())
				.category(from.getCategory())
				.price(from.getPrice())
				.active(from.isActive())
				.ownerId(from.getOwner().getId()).build();
	}

}
