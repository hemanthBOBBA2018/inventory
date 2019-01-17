package com.Hem.HelloTeacher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.Hem")
@SpringBootApplication

public class HelloTeacherInit {

	public static void main(String[] args) {
		SpringApplication.run(HelloTeacherInit.class, args);
	}

}