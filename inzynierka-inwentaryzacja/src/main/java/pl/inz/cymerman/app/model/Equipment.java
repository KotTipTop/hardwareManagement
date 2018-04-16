package pl.inz.cymerman.app.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Equipment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	private String manufacturer;
	private String model;
	@Temporal(TemporalType.DATE)
	private Date dateOfPurchase;
	private String serialNumber;
	private String software;
	private String technicalParameters;
	private String peripherials;
	@OneToMany(mappedBy = "equipment")
	private Set<Ownership> history;
	private BigDecimal price;
	@Temporal(TemporalType.DATE)
	private Date warranty;
	@ManyToOne
	@JoinColumn(name = "project_id")
	private Project project;
	@ManyToOne
	@JoinColumn(name = "location_id")
	private Location location;

	@CreatedDate
	@Column(nullable = true)
	private Date createDate;
	@LastModifiedDate
	@Column(nullable = true)
	private Date lastModifiedDate;
	
	@CreatedBy
	@Column(nullable = true)
	private String createBy;
	@LastModifiedBy
	@Column(nullable = true)
	private String lastModifiedBy;

}
