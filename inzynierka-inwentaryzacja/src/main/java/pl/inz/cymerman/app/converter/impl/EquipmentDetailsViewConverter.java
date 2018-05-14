package pl.inz.cymerman.app.converter.impl;



import java.util.Set;

import org.springframework.stereotype.Service;

import pl.inz.cymerman.app.converter.SimpleObjectConverter;
import pl.inz.cymerman.app.dto.CategoryNameOnlyDTO;
import pl.inz.cymerman.app.dto.EquipmentViewDetailsDTO;
import pl.inz.cymerman.app.dto.LocationNameOnlyDTO;
import pl.inz.cymerman.app.dto.OwnershipOwnerOnlyDTO;
import pl.inz.cymerman.app.dto.ProjectNameOnlyDTO;
import pl.inz.cymerman.app.model.Equipment;
import pl.inz.cymerman.app.model.Ownership;

@Service
public class EquipmentDetailsViewConverter implements SimpleObjectConverter<Equipment, EquipmentViewDetailsDTO>  {
	

	@Override
	public EquipmentViewDetailsDTO mapTo(Equipment from) {
		return EquipmentViewDetailsDTO.builder()
				.id(from.getId())
				.categoryName(from.getCategory()!=null?CategoryNameOnlyDTO.builder().id(from.getCategory().getId()).name(from.getCategory().getName()).build():null)
				.manufacturer(from.getManufacturer())
				.model(from.getModel())
				.dateOfPurchase(from.getDateOfPurchase())
				.serialNumber(from.getSerialNumber())
				.software(from.getSoftware())
				.technicalParameters(from.getTechnicalParameters())
				.owner(findOwner(from.getHistory()))
				.peripherials(from.getPeripherials())
				.price(from.getPrice())
				.warranty(from.getWarranty())
				.project(from.getProject() != null ? ProjectNameOnlyDTO.builder().id(from.getProject().getId()).name(from.getProject().getName()).build() : null)//nullpointerexp  Request processing failed; nested exception is java.lang.NullPointerException
				.location(from.getLocation() != null ?LocationNameOnlyDTO.builder().id(from.getLocation().getId()).name(from.getLocation().getName()).build() : null)
				.lastModifiedDate(from.getLastModifiedDate())
				.lastModifiedBy(from.getLastModifiedBy())
				.build();
	}

	private OwnershipOwnerOnlyDTO findOwner(Set<Ownership> history) {
		return history.stream().filter(h -> h.getAllocationEndDate()==null).findAny().map(this::mapToOwnerShipDto).orElse(null);
	}
	
	private OwnershipOwnerOnlyDTO mapToOwnerShipDto(Ownership ownership) {
		return OwnershipOwnerOnlyDTO.builder().id(ownership.getId()).fullName(ownership.getOwner().getName()+" "+ownership.getOwner().getSurname()).build();
	}
}
