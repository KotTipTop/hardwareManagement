package pl.kurs.spring.employee.command;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeAddCommand {

	@NotNull
	private String name;
	@NotNull
	private String surname;
	@NotNull
	@Min(value = 0, message = "Salary cannot be negative!")
	private Integer salary;
	@NotNull
	private String position;

}
