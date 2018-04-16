package pl.inz.cymerman.app.service;

import java.util.List;

import pl.inz.cymerman.app.model.Ownership;

public interface OwnershipService {
	List<Ownership> findAll();
	Ownership findOne(Long id);
	void delete(Long id);
	Ownership save(Ownership model);
	Ownership ownershipByUserIdAndAllocationDate(Long id);
}
