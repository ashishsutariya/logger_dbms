package com.dbms.project1.v1;

import org.springframework.boot.SpringApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.dbms.project1.v1.model"})
@ComponentScan(basePackages = {"com.dbms.project1.v1"})
//@EntityScan(basePackages = "com.dbms.project1.v1.model")
public class Project1Application {

	public static void main(String[] args) {
		SpringApplication.run(Project1Application.class, args);
	}

}
