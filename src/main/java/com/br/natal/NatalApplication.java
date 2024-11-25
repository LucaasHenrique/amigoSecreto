package com.br.natal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.br.natal"})
@SpringBootApplication
public class NatalApplication {

	public static void main(String[] args) {
		SpringApplication.run(NatalApplication.class, args);
	}

}
