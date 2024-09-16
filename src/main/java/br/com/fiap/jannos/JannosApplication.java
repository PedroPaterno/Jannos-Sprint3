package br.com.fiap.jannos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@EntityScan
@ComponentScan
@SpringBootApplication
public class JannosApplication {

	public static void main(String[] args) {
		SpringApplication.run(JannosApplication.class, args);
	}

}
