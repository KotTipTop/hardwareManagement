package pl.inz.cymerman.app.service;

import java.util.List;

import pl.inz.cymerman.app.dto.UserEditFormDTO;
import pl.inz.cymerman.app.model.Department;
import pl.inz.cymerman.app.model.User;

public interface UserService {
	List<User> findAll();
	User findOne(Long id);
	void delete(Long id);
	User save(User model);
	boolean isUserWithSameLogin(String login);
	void setPassword(User user);
	void editUserDetails(UserEditFormDTO user, User u, Department d);
}
