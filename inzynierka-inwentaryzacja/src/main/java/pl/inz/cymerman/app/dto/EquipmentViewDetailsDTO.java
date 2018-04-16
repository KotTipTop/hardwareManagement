package pl.inz.cymerman.app.dto;

import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EquipmentViewDetailsDTO {
	private Long id;
	private CategoryNameOnlyDTO categoryName;
	private String manufacturer;
	private String model;
	private Date dateOfPurchase;
	private String serialNumber;
	private String software;
	private String technicalParameters;
	private String peripherials;
	private OwnershipOwnerOnlyDTO owner;
	private BigDecimal price;
	private Date warranty;
	private ProjectNameOnlyDTO project;
	private LocationNameOnlyDTO location;
	private Date lastModifiedDate;
	private String lastModifiedBy;
}
