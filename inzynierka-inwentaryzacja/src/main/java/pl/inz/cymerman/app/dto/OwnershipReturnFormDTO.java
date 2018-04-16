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
public class OwnershipReturnFormDTO {
	private Long ownerId;
	private Long equipmentId;
	private Date allocationEndDate;
}
