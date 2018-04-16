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
public class EquipmentTableViewDTO {
	private Long id;
	private CategoryNameOnlyDTO category;
	private String manufacturer;
	private String model;
	private Date dateOfPurchase;
	private String serialNumber;
	private BigDecimal price;
	private OwnershipOwnerOnlyDTO owner;
	
}
