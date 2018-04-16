package pl.inz.cymerman.app.converter.impl;

import org.springframework.stereotype.Service;

import pl.inz.cymerman.app.converter.SimpleObjectConverter;
import pl.inz.cymerman.app.dto.UserNameOnlyDTO;
import pl.inz.cymerman.app.model.User;

@Service
public class UserNameOnlyConverter implements SimpleObjectConverter<User, UserNameOnlyDTO>{

	@Override
	public UserNameOnlyDTO mapTo(User from) {
		return UserNameOnlyDTO.builder().id(from.getId()).fullName(from.getName()+" "+from.getSurname()).build();
	}

}
