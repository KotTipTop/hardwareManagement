package pl.kurs.spring.employee.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDTO {

	@NotNull
	private Long id;
	private String name;
	private String surname;
	private int salary;
	private String position;
}
