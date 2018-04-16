package pl.inz.cymerman.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.inz.cymerman.app.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
