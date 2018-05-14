package pl.inz.cymerman.app.converter.impl;

import org.springframework.stereotype.Service;

import pl.inz.cymerman.app.converter.SimpleObjectConverter;
import pl.inz.cymerman.app.dto.LocationNameOnlyDTO;
import pl.inz.cymerman.app.dto.OwnershipEquipmentHistoryDetailsDTO;
import pl.inz.cymerman.app.dto.ProjectNameOnlyDTO;
import pl.inz.cymerman.app.dto.UserNameOnlyDTO;
import pl.inz.cymerman.app.model.Ownership;

@Service
public class OwnershipEquipmentHistoryDetailsConverter implements SimpleObjectConverter<Ownership, OwnershipEquipmentHistoryDetailsDTO>
{
	@Override
	public OwnershipEquipmentHistoryDetailsDTO mapTo(Ownership from) {
		return OwnershipEquipmentHistoryDetailsDTO.builder()
				.id(from.getId())
				.owner(from.getOwner()!=null?UserNameOnlyDTO.builder()
						.id(from.getOwner().getId())
						.fullName(from.getOwner().getName()+" "+from.getOwner().getSurname()).build():null)
				.allocationStartDate(from.getAllocationStartDate()!=null ? from.getAllocationStartDate() : null)
				.allocationEndDate(from.getAllocationEndDate()!=null ? from.getAllocationEndDate():null)
				.location(from.getLocation()!=null? LocationNameOnlyDTO.builder()
						.id(from.getLocation().getId())
						.name(from.getLocation().getName()).build():null)
				.project(from.getProject()!=null ? ProjectNameOnlyDTO.builder().id(from.getProject().getId()).name(from.getProject().getName()).build():null).build();
	}

	
}
