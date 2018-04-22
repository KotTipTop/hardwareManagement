package pl.inz.cymerman.app.service.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.inz.cymerman.app.dto.UserEditFormDTO;
import pl.inz.cymerman.app.model.Department;
import pl.inz.cymerman.app.model.User;
import pl.inz.cymerman.app.repository.RoleRepository;
import pl.inz.cymerman.app.repository.UserRepository;
import pl.inz.cymerman.app.service.UserService;

@Transactional
@Service
public class UserAdminImpl implements UserService {
	private final UserRepository userRepository;
	private final RoleRepository roleRepository;

	@Autowired
	public UserAdminImpl(UserRepository userRepository, RoleRepository roleRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}

	@Override
	public List<User> findAll() {

		return userRepository.findAll();
	}

	@Override
	public User findOne(Long id) {
		return userRepository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		userRepository.delete(id);

	}

	@Override
	public User save(User model) {
		return userRepository.saveAndFlush(model);
	}

	@Override
	public boolean isUserWithSameLogin(String login) {
		return userRepository.isUserWithSameLogin(login);
	}

	@Override
	public void setPassword(User user) {
		String nameLowCase = StringUtils.stripAccents(user.getName().toLowerCase());
		String surnameLowCase = StringUtils.stripAccents(user.getSurname().toLowerCase());
		String login = nameLowCase.charAt(0) + "." + surnameLowCase;
		if (isUserWithSameLogin(login)) {
			for (int i = 1; i < 10; i++) {
				if (!isUserWithSameLogin(login + i)) {
					user.setLogin(nameLowCase.charAt(0) + "." + surnameLowCase + i);
					break;
				}
			}
		} else {
			user.setLogin(nameLowCase.charAt(0) + "." + surnameLowCase);
		}
		user.setPassword(new BCryptPasswordEncoder().encode(nameLowCase));

	}

	@Override
	public void editUserDetails(UserEditFormDTO user, User u, Department d) {
		u.setName(user.getName());
		u.setSurname(user.getSurname());
		u.setPhoneNumber(user.getPhoneNumber());
		u.setEmail(user.getEmail());
		u.setLogin(user.getLogin());
		u.setPassword(user.getPassword());
		u.setDepartment(d);
		u.setRoles(new HashSet<>(new HashSet<>(Arrays.asList(roleRepository.findOne(user.getRoleId())))));
	}

}
