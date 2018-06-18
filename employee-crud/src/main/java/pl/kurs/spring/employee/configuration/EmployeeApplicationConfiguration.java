package pl.kurs.spring.employee.configuration;

import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import pl.kurs.spring.converter.ObjectConverter;
import pl.kurs.spring.converter.SimpleObjectConverter;

@Configuration
@ComponentScan(basePackages = "pl.kurs.spring.employee")
public class EmployeeApplicationConfiguration {

	@Bean
	public <T, R> ObjectConverter objectConverter(Set<SimpleObjectConverter<T, R>> converters) {
		return new ObjectConverter(converters);
	}

}
