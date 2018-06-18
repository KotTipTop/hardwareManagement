package pl.kurs.spring.employee.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class EmployeeApplicationSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService authUserService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()//
				.authorizeRequests()//
				.antMatchers(HttpMethod.POST, "/employee/**").authenticated()//
				.antMatchers(HttpMethod.PUT, "/employee/**").authenticated()//
				.antMatchers(HttpMethod.DELETE, "/employee/**").authenticated()//
				.antMatchers(HttpMethod.POST, "/equipment/**").authenticated()//
				.antMatchers(HttpMethod.PUT, "/equipment/**").authenticated()//
				.antMatchers(HttpMethod.DELETE, "/equipment/**").authenticated()//
				.anyRequest().permitAll()//
				.and().httpBasic();
	}

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(authUserService);
	}


}
