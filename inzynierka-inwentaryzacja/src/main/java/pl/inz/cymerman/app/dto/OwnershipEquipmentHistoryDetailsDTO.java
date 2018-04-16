package pl.inz.cymerman.app.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OwnershipEquipmentHistoryDetailsDTO {
	private Long id;
	private UserNameOnlyDTO owner;
	private Date allocationStartDate;
	private Date allocationEndDate;
	private LocationNameOnlyDTO location;
	private ProjectNameOnlyDTO project;
}
