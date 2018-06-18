package pl.kurs.spring.employee.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String surname;
	private int salary;
	private String position;
	private boolean active;
	
	@OneToMany(mappedBy = "owner")
	private Set<Equipment> equipment;

	public void addEquipment(Equipment e) {
		equipment.add(e);
		e.setOwner(this);
	}

	public boolean removeEquipment(Equipment e) {
		if(equipment.remove(e)) {
			e.setOwner(null);
			return true;
		}
		return false;

	}



}
