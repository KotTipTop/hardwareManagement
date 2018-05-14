package pl.inz.cymerman.app.service;

import java.util.List;
import pl.inz.cymerman.app.model.Role;

public interface RoleService {
	List<Role> findAll();
	Role findOne(Long id);
}
