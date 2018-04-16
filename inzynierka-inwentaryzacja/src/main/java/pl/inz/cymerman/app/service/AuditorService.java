package pl.inz.cymerman.app.service;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

import pl.inz.cymerman.app.model.User;

public class AuditorService implements AuditorAware<String> {

	@Override
	public String getCurrentAuditor() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return user == null ? "Anonim" : user.getLogin();
	}

}
