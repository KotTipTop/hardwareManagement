package pl.inz.cymerman.app.converter.impl;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;

import pl.inz.cymerman.app.converter.SimpleObjectConverter;
import pl.inz.cymerman.app.dto.UserEditFormDTO;
import pl.inz.cymerman.app.model.User;
import pl.inz.cymerman.app.repository.DepartmentRepository;
import pl.inz.cymerman.app.repository.RoleRepository;

public class UserEditToUserConverter implements SimpleObjectConverter<UserEditFormDTO,User> {
private final DepartmentRepository departmentRepository;
private final RoleRepository roleRepository;


@Autowired
public UserEditToUserConverter(DepartmentRepository departmentRepository, RoleRepository roleRepository) {
	this.departmentRepository = departmentRepository;
	this.roleRepository = roleRepository;
}

@Override
public User mapTo(UserEditFormDTO from) {
	
	return User.builder()
			.id(from.getId())
			.name(from.getName())
			.surname(from.getSurname())
			.email(from.getEmail())
			.phoneNumber(from.getPhoneNumber())
			.department(departmentRepository.findOne(from.getDepartmentId()))
			.login(from.getLogin())
			.password(from.getPassword())
			.roles(new HashSet<>(Arrays.asList(roleRepository.findOne(from.getRoleId())))).build();
}



}
