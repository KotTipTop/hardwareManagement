package pl.inz.cymerman.app.model;

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
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Long projectNumber;
	@OneToMany(mappedBy="project")
	private Set<Equipment> projectequip;
	@OneToMany(mappedBy="project")
	private Set<Ownership> ownershipInProject;
	public Project(Long id) {
		this.id = id;
	}

}
