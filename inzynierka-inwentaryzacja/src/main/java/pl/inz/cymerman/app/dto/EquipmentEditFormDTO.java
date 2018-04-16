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
public class EquipmentEditFormDTO {
	private Long categoryId;
	private String manufacturer;
	private String model;
	private Date dateOfPurchase;
	private String serialNumber;
	private String software;
	private String technicalParameters;
	private String peripherials;
	private BigDecimal price;
	private Date warranty;
	private Long projectId;
	private Long locationId;
}
