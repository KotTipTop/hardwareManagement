package pl.inz.cymerman.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.inz.cymerman.app.model.Equipment;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {

	@Query("select count(e) from Equipment e join e.history h where h.allocationEndDate = null and h.owner.id = :ownerId and e.category.name = :categoryName")
	long countForUserByCategoryName(@Param("ownerId")Long id, @Param("categoryName") String categoryName);
	@Query("select e from Equipment e join e.history h where h.allocationEndDate = null and h.owner.id = :ownerId and e.category.name = :categoryName")
	List<Equipment> EquipmentForUserByCategoryName(@Param("ownerId")Long id, @Param("categoryName") String categoryName);
	
}
