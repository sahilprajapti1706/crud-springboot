package com.sahil.crud_springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication
public class CrudSpringbootApplication {

	public static void main(String[] args) {

		SpringApplication.run(CrudSpringbootApplication.class, args);

		System.out.println("Hello World");
	}


}
