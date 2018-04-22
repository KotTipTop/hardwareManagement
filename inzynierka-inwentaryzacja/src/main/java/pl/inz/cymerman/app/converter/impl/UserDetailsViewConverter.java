package pl.inz.cymerman.app.converter.impl;

import org.springframework.stereotype.Service;

import pl.inz.cymerman.app.converter.SimpleObjectConverter;
import pl.inz.cymerman.app.dto.DepartmentNameOnlyDTO;
import pl.inz.cymerman.app.dto.UserViewDetailsDTO;
import pl.inz.cymerman.app.model.User;

@Service
public class UserDetailsViewConverter implements SimpleObjectConverter<User, UserViewDetailsDTO> {

	@Override
	public UserViewDetailsDTO mapTo(User from) {
		
		return UserViewDetailsDTO.builder()
				.id(from.getId())
				.name(from.getName())
				.surname(from.getSurname())
				.phoneNumber(from.getPhoneNumber())
				.email(from.getEmail())
				.login(from.getLogin())
				.department(from.getDepartment() !=null ? DepartmentNameOnlyDTO.builder().id(from.getDepartment().getId()).name(from.getDepartment().getName()).build(): null).build();
				
	}
}
