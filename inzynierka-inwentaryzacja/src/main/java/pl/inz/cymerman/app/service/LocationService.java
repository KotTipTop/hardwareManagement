package pl.inz.cymerman.app.service;

import java.util.List;

import pl.inz.cymerman.app.model.Location;

public interface LocationService {
	List<Location> findAll();
	Location findOne(Long id);
	void delete(Long id);
	Location save(Location model);
}
