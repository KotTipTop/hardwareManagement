package pl.kurs.spring.employee.dto;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EquipmentDTO {
	private Long id;
	private String name;
	private String category;
	private int price;
	private Long ownerId;
	private boolean active;
}
