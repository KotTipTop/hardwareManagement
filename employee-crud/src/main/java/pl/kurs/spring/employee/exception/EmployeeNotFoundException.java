package pl.kurs.spring.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = false)
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 4164001059797349438L;
	private Long employeeId;

	@Override
	public String getMessage() {
		return "Employee with id " + employeeId + " doesn't exist!";
	}
}
