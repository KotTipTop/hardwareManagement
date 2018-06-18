package pl.kurs.spring.employee.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import pl.kurs.spring.employee.validation.impl.CheckIfEmployeeIdExistsValidator;

@Target(value = ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckIfEmployeeIdExistsValidator.class)
public @interface CheckIfEmployeeIdExists {

    String message() default "Brak obiektu o takim Id";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
