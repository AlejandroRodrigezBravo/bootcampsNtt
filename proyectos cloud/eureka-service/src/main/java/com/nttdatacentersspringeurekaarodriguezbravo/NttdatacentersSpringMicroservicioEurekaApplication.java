package com.nttdatacentersspringeurekaarodriguezbravo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class NttdatacentersSpringMicroservicioEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(NttdatacentersSpringMicroservicioEurekaApplication.class, args);
	}

}
