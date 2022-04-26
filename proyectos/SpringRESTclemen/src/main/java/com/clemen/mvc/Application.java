package com.clemen.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;

@EnableEurekaClient
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		ApplicationContext context  = SpringApplication.run(Application.class, args);
	}


}
