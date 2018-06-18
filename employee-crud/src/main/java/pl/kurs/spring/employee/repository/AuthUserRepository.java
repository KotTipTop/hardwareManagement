package pl.kurs.spring.employee.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.kurs.spring.employee.model.AuthUser;
//daily, zaraz jestem, ja cie slysze ty mnie nie:)
public interface AuthUserRepository extends JpaRepository<AuthUser, Long> {
	@Query("select u from AuthUser u left join fetch u.roles where u.name =:name")
	Optional<AuthUser> findByName(@Param("name") String name);
}
