package pl.inz.cymerman.app.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import pl.inz.cymerman.app.service.AuditorService;

@Configuration
@EnableJpaRepositories(basePackages = "pl.inz.cymerman.app.repository")
@EntityScan(basePackages = "pl.inz.cymerman.app.model")
@EnableTransactionManagement
@EnableJpaAuditing(auditorAwareRef="auditorService")
public class AppPersistanceConfig {
	@Bean
	public AuditorAware<String> auditorService() {
		return new AuditorService();
	}
}
