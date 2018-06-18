package pl.kurs.spring.employee.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.kurs.spring.employee.validation.annotation.CheckIfEmployeeIdExists;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeEditCommand {

	@CheckIfEmployeeIdExists
	private Long id;
	private String name;
	private String surname;
	private Integer salary;
	private String position;
	private boolean active;
}
