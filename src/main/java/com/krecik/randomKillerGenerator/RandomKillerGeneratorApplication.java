package com.krecik.randomKillerGenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class RandomKillerGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(RandomKillerGeneratorApplication.class, args);
	}

}
