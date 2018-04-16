package pl.inz.cymerman.app.converter.impl;

import org.springframework.stereotype.Service;

import pl.inz.cymerman.app.converter.SimpleObjectConverter;
import pl.inz.cymerman.app.dto.LocationNameOnlyDTO;
import pl.inz.cymerman.app.model.Location;

@Service
public class LocationNameOnlyConverter implements SimpleObjectConverter<Location, LocationNameOnlyDTO> {

	@Override
	public LocationNameOnlyDTO mapTo(Location from) {
		return LocationNameOnlyDTO.builder().id(from.getId()!=null ? from.getId():null).name(from.getName()!=null ? from.getName():null).build();
	}


}
