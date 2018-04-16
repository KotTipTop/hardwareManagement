package pl.inz.cymerman.app.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.inz.cymerman.app.model.Role;
import pl.inz.cymerman.app.repository.RoleRepository;
import pl.inz.cymerman.app.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl implements RoleService{

	private final RoleRepository roleRepository;
	@Autowired
	public RoleServiceImpl(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	@Override
	public List<Role> findAll() {
		return roleRepository.findAll();
	}

	@Override
	public Role findOne(Long id) {
		return roleRepository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		roleRepository.delete(id);
		
	}

	@Override
	public Role save(Role model) {
		return roleRepository.saveAndFlush(model);
	}
	
}
