package pl.inz.cymerman.app.converter.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.inz.cymerman.app.converter.SimpleObjectConverter;
import pl.inz.cymerman.app.dto.OwnershipAssignFormDTO;
import pl.inz.cymerman.app.model.Ownership;
import pl.inz.cymerman.app.repository.EquipmentRepository;
import pl.inz.cymerman.app.repository.LocationRepository;
import pl.inz.cymerman.app.repository.ProjectRepository;
import pl.inz.cymerman.app.repository.UserRepository;

@Service
public class OwnershipAssignToOwnershipConverter implements SimpleObjectConverter<OwnershipAssignFormDTO, Ownership> {

	private final EquipmentRepository equipmentRepository;
	private final UserRepository userRepository;
	private final LocationRepository locationRepository;
	private final ProjectRepository projectRepository;
	
	
	
	@Autowired
	public OwnershipAssignToOwnershipConverter(EquipmentRepository equipmentRepository, UserRepository userRepository,
			LocationRepository locationRepository, ProjectRepository projectRepository) {
		this.equipmentRepository = equipmentRepository;
		this.userRepository = userRepository;
		this.locationRepository = locationRepository;
		this.projectRepository = projectRepository;
	}




	@Override
	public Ownership mapTo(OwnershipAssignFormDTO from) {
		return Ownership.builder()
				.allocationStartDate(from.getAllocationStartDate())//
				.equipment(from.getEquipmentId() != null ? equipmentRepository.findOne(from.getEquipmentId()):null)//
				.owner(from.getOwnerId() != null ? userRepository.findOne(from.getOwnerId()):null)
				.location(from.getLocationId()!= null ? locationRepository.findOne(from.getLocationId()):null)
				.project(from.getProjectId() != null ? projectRepository.findOne(from.getProjectId()):null).build();//
	}

}
