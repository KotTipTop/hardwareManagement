package pl.kurs.spring.employee.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EquipmentAddCommand {
	private String name;
	private String category;
	private int price;
	private boolean active;
}
