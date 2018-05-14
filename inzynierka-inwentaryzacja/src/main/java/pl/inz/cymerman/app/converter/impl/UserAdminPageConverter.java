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
		return UserDetailsAdminPageInfoDTO.builder().id(from.getId()).fullName(from.getName()!=null? from.getName() + " " + from.getSurname():null)
				.roles(from.getRoles()!=null?from.getRoles().stream().map(roleConverter::mapTo).collect(Collectors.toSet()):null)
				.department(from.getDepartment()!=null?DepartmentNameOnlyDTO.builder().id(from.getDepartment().getId()).name(from.getDepartment().getName()).build():null)
				.build();

	}
}