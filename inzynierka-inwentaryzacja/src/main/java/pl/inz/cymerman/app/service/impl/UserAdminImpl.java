package pl.inz.cymerman.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.inz.cymerman.app.model.User;
import pl.inz.cymerman.app.repository.UserRepository;
import pl.inz.cymerman.app.service.UserService;

@Transactional
@Service
public class UserAdminImpl implements UserService{
	private final UserRepository userRepository;
	
	@Autowired
	public UserAdminImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
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

}
