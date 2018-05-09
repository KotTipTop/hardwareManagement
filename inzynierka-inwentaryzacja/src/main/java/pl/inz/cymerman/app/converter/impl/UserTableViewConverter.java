package pl.inz.cymerman.app.converter.impl;

import org.springframework.stereotype.Service;

import pl.inz.cymerman.app.converter.SimpleObjectConverter;
import pl.inz.cymerman.app.dto.DepartmentNameOnlyDTO;
import pl.inz.cymerman.app.dto.UserTableViewDTO;
import pl.inz.cymerman.app.model.User;

@Service
public class UserTableViewConverter implements SimpleObjectConverter<User, UserTableViewDTO> {

	@Override
	public UserTableViewDTO mapTo(User from) {

		return UserTableViewDTO.builder()
				.id(from.getId())
				.fullName(from.getName()+" "+from.getSurname())
				.phoneNumber(from.getPhoneNumber())
				.email(from.getEmail())
				.departmentName(from.getDepartment() !=null ? DepartmentNameOnlyDTO.builder().id(from.getDepartment().getId())
						.name(from.getDepartment().getName()).build(): null).active(from.isActive()).build();
	}

}
