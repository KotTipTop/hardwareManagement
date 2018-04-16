package pl.inz.cymerman.app.converter.impl;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import pl.inz.cymerman.app.converter.SimpleObjectConverter;
import pl.inz.cymerman.app.dto.DepartmentNameOnlyDTO;
import pl.inz.cymerman.app.dto.UserDetailsAdminPageInfoDTO;
import pl.inz.cymerman.app.model.User;

@Service
public class UserAdminPageConverter implements SimpleObjectConverter<User, UserDetailsAdminPageInfoDTO> {
	private final RoleConverter roleConverter;

	public UserAdminPageConverter(RoleConverter roleConverter) {
		this.roleConverter = roleConverter;
	}

	@Override
	public UserDetailsAdminPageInfoDTO mapTo(User from) {
		return UserDetailsAdminPageInfoDTO.builder().id(from.getId()).fullName(from.getName() + " " + from.getSurname())
				.roles(from.getRoles().stream().map(roleConverter::mapTo).collect(Collectors.toSet()))
				.department(DepartmentNameOnlyDTO.builder().id(from.getDepartment().getId()).name(from.getDepartment().getName()).build())
				.build();

	}
}// kupa?
	// .role(RoleDTO.builder()
	// .id(from.getId())
	// .roleName(from.getRoles().stream().filter(o->o.getRoleName().equals("ROLE_ADMIN")).toString()).build()).build();