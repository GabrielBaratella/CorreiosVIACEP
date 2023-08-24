package br.com.baratellagabriel.correios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CorreiosApplication {
	
	private static ConfigurableApplicationContext context;

	public static void main(String[] args) {
		context = SpringApplication.run(CorreiosApplication.class, args);
	}
	
	public static void close(int code) {
		SpringApplication.exit(context,() -> code);
	}

}

