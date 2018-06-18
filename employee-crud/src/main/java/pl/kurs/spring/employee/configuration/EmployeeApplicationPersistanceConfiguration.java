package pl.kurs.spring.employee.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "pl.kurs.spring.employee.repository")
@EntityScan(basePackages = "pl.kurs.spring.employee.model")
@EnableTransactionManagement
public class EmployeeApplicationPersistanceConfiguration {

}
