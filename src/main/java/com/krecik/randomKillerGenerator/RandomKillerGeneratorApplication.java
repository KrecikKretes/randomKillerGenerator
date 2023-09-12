package com.krecik.randomKillerGenerator;


import com.krecik.randomKillerGenerator.repository.KillerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.sql.SQLException;

@SpringBootApplication
public class RandomKillerGeneratorApplication{

	public static void main(String[] args) {
		SpringApplication.run(RandomKillerGeneratorApplication.class, args);

		/*
		ConfigurableApplicationContext context = SpringApplication.run(RandomKillerGeneratorApplication.class, args);
		Object dataSource = context.getBean("dataSource");
		System.out.println(dataSource);

		 */
	}

}
