package pl.inz.cymerman.app.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(value = AppConfig.class)
public class AppMain  {
	public static void main(String[] args) {
		SpringApplication.run(AppMain.class, args);
	}

}