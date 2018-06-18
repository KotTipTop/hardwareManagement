package pl.kurs.spring.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.EqualsAndHashCode;
import lombok.Value;


@Value
@EqualsAndHashCode(callSuper = false)
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class OwnershipNotFoundException extends RuntimeException{
	private static final long serialVersionUID = -7496635508500331175L;
	private Long equipmentId;
	
	@Override
	public String getMessage() {
		return "Equipment with id " + equipmentId + " doesn't belong to this user";
	}


}
