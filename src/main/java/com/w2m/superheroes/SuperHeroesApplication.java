package com.w2m.superheroes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.w2m.superheroes" })
public class SuperHeroesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SuperHeroesApplication.class, args);
	}

}
