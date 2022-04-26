package com.nttdatacentersspringt2bravo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;


@EnableConfigServer // anotacion para activar nuestrro proyecto como un servidor
@SpringBootApplication
public class NTTDataSpringConfirServeBravo {

	public static void main(String[] args) {
		SpringApplication.run(NTTDataSpringConfirServeBravo.class, args);
	}


}
