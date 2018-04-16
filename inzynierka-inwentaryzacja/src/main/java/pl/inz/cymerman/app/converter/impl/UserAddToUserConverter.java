package pl.inz.cymerman.app.converter.impl;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.inz.cymerman.app.converter.SimpleObjectConverter;
import pl.inz.cymerman.app.dto.UserAddFormDTO;
import pl.inz.cymerman.app.model.User;
import pl.inz.cymerman.app.repository.DepartmentRepository;
import pl.inz.cymerman.app.repository.RoleRepository;

@Service
public class UserAddToUserConverter implements SimpleObjectConverter<UserAddFormDTO, User> {
	private final DepartmentRepository departmentRepository;
	private final RoleRepository roleRepository;

	@Autowired
	public UserAddToUserConverter(DepartmentRepository departmentRepository, RoleRepository roleRepository) {
		this.departmentRepository = departmentRepository;
		this.roleRepository = roleRepository;
	}

	@Override
	public User mapTo(UserAddFormDTO from) {
		return User.builder().name(from.getName()).surname(from.getSurname()).phoneNumber(from.getPhoneNumber())
				.department(departmentRepository.findOne(from.getDepartmentId()))
				.roles(new HashSet<>(Arrays.asList(roleRepository.findOne(from.getRoleId())))).build();

	}
}