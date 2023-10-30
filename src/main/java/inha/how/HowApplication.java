package inha.how;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@OpenAPIDefinition(
		servers = {
				@Server(url="http://52.78.0.53", description = "Default Server url")
		}
)

//시큐리티 기능 끄기
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class HowApplication {

	public static void main(String[] args) {
		SpringApplication.run(HowApplication.class, args);
	}

}
