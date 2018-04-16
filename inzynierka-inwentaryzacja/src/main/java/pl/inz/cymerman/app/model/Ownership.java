package pl.inz.cymerman.app.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode (exclude= { "equipment", "owner","project","location"})
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ownership {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne()
	@JoinColumn(name = "user_id")
	private User owner;
	@ManyToOne()
	@JoinColumn(name ="equipment_id")
	private Equipment equipment;
	@Temporal(TemporalType.DATE)
	private Date allocationStartDate;
	@Temporal(TemporalType.DATE)
	private Date allocationEndDate;
	@ManyToOne()
	@JoinColumn(name = "project_id")
	private Project project;
	@ManyToOne()
	@JoinColumn(name = "location_id")
	private Location location;
}
