package tech.kimari.sa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@SpringBootApplication
public class SaBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SaBackendApplication.class, args);
	}

}
