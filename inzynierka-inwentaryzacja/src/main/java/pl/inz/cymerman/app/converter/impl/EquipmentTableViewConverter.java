package pl.inz.cymerman.app.converter.impl;

import java.util.Set;

import org.springframework.stereotype.Service;

import pl.inz.cymerman.app.converter.SimpleObjectConverter;
import pl.inz.cymerman.app.dto.CategoryNameOnlyDTO;
import pl.inz.cymerman.app.dto.EquipmentTableViewDTO;
import pl.inz.cymerman.app.dto.OwnershipOwnerOnlyDTO;
import pl.inz.cymerman.app.model.Equipment;
import pl.inz.cymerman.app.model.Ownership;

@Service
public class EquipmentTableViewConverter implements SimpleObjectConverter<Equipment, EquipmentTableViewDTO> {

	@Override
	public EquipmentTableViewDTO mapTo(Equipment from) {
		return EquipmentTableViewDTO.builder()
				.id(from.getId())
				.category(from.getCategory()!=null?CategoryNameOnlyDTO.builder()
				.id(from.getCategory().getId()).name(from.getCategory().getName()).build():null).manufacturer(from.getManufacturer())
				.model(from.getModel())
				.dateOfPurchase(from.getDateOfPurchase())
				.serialNumber(from.getSerialNumber())
				.price(from.getPrice())
				.owner(from.getHistory()!=null?findOwner(from.getHistory()):null)
				.active(from.isActive())
				.build();
	}
	private OwnershipOwnerOnlyDTO findOwner(Set<Ownership> history) {
		return history.stream().filter(h -> h.getAllocationEndDate()==null).findAny().map(this::mapToOwnerShipDto).orElse(null);
	}
	
	private OwnershipOwnerOnlyDTO mapToOwnerShipDto(Ownership ownership) {
		return OwnershipOwnerOnlyDTO.builder().id(ownership.getId()).fullName(ownership.getOwner().getName()+" "+ownership.getOwner().getSurname()).build();
	}
}
