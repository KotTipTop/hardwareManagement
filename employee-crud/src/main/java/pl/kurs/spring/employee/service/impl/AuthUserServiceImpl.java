package pl.kurs.spring.employee.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pl.kurs.spring.employee.repository.AuthUserRepository;

@Service
public class AuthUserServiceImpl implements UserDetailsService {

	private final AuthUserRepository userRepository;

	@Autowired
	public AuthUserServiceImpl(AuthUserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		return userRepository.findByName(login).orElseThrow(() -> new UsernameNotFoundException("Not found: " + login));
	}

}
