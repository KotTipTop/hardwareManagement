package pl.inz.cymerman.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		
		//które url mogą być pomijane przez security context.
		web.ignoring().antMatchers("/resources/**");

		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()//
//				.antMatchers("/index/**").access("hasRole('ADMIN')")//
//				.antMatchers("/produckty/**").access("hasRole('MAGAZYNIER')")//
				.antMatchers("/login/**").permitAll()//
				.anyRequest().authenticated()//
				.and()//
				.formLogin().loginPage("/login")//
				.defaultSuccessUrl("/index/")//
				.failureUrl("/login?errorLogin=true")//
				.usernameParameter("username").passwordParameter("password")//
				.and()//
				.logout().logoutSuccessUrl("/login?logout=true")//
				.and()//
				.rememberMe()
				.and()
				.exceptionHandling().accessDeniedPage("/denide");
	}

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
