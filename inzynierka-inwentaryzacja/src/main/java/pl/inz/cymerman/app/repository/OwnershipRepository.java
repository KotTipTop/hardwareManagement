package pl.inz.cymerman.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.inz.cymerman.app.model.Ownership;

public interface OwnershipRepository extends JpaRepository<Ownership, Long>{
	@Query("select o from Ownership o where o.equipment.id =:equipmentId and o.allocationEndDate = null")
	Ownership ownershipByEquipmentId(@Param("equipmentId") Long id);
	//@Ouery("select o from Equipment e join e.history o where o.allocationEndDate = null and ")
}
