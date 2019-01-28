package com.hemanth.MongoInterface.MongoDBInteraction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.apache.log4j.Logger;


@ComponentScan("com.hemanth")
@SpringBootApplication
@EnableWebMvc
public class MongoDbInteractionApplication {

	final static Logger logger = Logger.getLogger(MongoDbInteractionApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(MongoDbInteractionApplication.class, args);
	}

}

