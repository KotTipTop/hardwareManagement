package pl.inz.cymerman.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.inz.cymerman.app.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	@Query("select u from User u left join fetch u.roles where u.login= :login")
	Optional<User> findByLogin(@Param("login") String login);
	@Query("select case when count(u)>0 then true else false end from User u where u.login = :login")
	boolean isUserWithSameLogin(@Param("login") String login);
}
