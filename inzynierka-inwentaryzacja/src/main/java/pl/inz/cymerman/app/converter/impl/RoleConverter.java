package pl.inz.cymerman.app.converter.impl;

import org.springframework.stereotype.Service;

import pl.inz.cymerman.app.converter.SimpleObjectConverter;
import pl.inz.cymerman.app.dto.RoleDTO;
import pl.inz.cymerman.app.model.Role;

@Service
public class RoleConverter implements SimpleObjectConverter<Role, RoleDTO> {

	@Override
	public RoleDTO mapTo(Role from) {
		return RoleDTO.builder().id(from.getId()).roleName(from.getRoleName()).build();
	}
}
