package pl.inz.cymerman.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.inz.cymerman.app.model.Ownership;
import pl.inz.cymerman.app.repository.OwnershipRepository;
import pl.inz.cymerman.app.service.OwnershipService;

@Service
@Transactional
public class OwnershipServiceImpl implements OwnershipService{
	private final OwnershipRepository ownershipRepository;
	@Autowired
	public OwnershipServiceImpl(OwnershipRepository ownershipRepository) {
		this.ownershipRepository = ownershipRepository;
	}
	@Override
	public List<Ownership> findAll() {
		return ownershipRepository.findAll();
	}
	@Override
	public Ownership findOne(Long id) {
		return ownershipRepository.findOne(id);
	}
	@Override
	public Ownership save(Ownership model) {
		return ownershipRepository.save(model);
	}
	@Override
	public Ownership ownershipByUserIdAndAllocationDate(Long id) {
		return ownershipRepository.ownershipByEquipmentId(id);
	}
	
	
}
