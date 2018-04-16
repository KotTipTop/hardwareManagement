package pl.inz.cymerman.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.inz.cymerman.app.model.Location;

public interface LocationRepository extends JpaRepository<Location, Long>{

}
