package pl.inz.cymerman.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.inz.cymerman.app.model.Location;
import pl.inz.cymerman.app.repository.LocationRepository;
import pl.inz.cymerman.app.service.LocationService;

@Service
@Transactional
public class LocationServiceImpl implements LocationService {

	private final LocationRepository locationRepository;
	
	@Autowired
	public LocationServiceImpl(LocationRepository locationRepository) {
		this.locationRepository = locationRepository;
	}

	@Override
	public List<Location> findAll() {
		return locationRepository.findAll();
	}

	@Override
	public Location findOne(Long id) {
		return locationRepository.findOne(id);
	}

}
