package com.nttdatacentersspringeurekaarodriguezbravo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@EnableAdminServer
@SpringBootApplication
public class NttdatacentersSpringAdminBravoApplication {

	public static void main(String[] args) {
		SpringApplication.run(NttdatacentersSpringAdminBravoApplication.class, args);
	}

}
