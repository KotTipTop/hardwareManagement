package pl.kurs.spring.employee.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EquipmentEditCommand {
	private Long id;
	private String name;
	private String category;
	private int price;
	//sprawdzic czy zmienic
	private Long ownerId;
	private boolean active;
}
