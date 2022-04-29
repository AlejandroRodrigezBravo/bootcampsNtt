package com.aguezbravo.springboot.webflux.app;


import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

import com.aguezbravo.springboot.webflux.app.dao.ProductoDao;
import com.aguezbravo.springboot.webflux.app.models.documents.Producto;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class SpringbootWebfluxApplication implements CommandLineRunner{

	@Autowired
	private ProductoDao dao;
	
	@Autowired
	private ReactiveMongoTemplate mongoTemplete;
	
	private static final Logger log = LoggerFactory.getLogger(SpringbootWebfluxApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootWebfluxApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		mongoTemplete.dropCollection("productos").subscribe();
		
		Flux.just(new Producto("Bomba de agua", 230.99),
				new Producto("Goma 50 metros", 25.40),
				new Producto("Goma 40 metros", 20.234),
				new Producto("Goma 30 metros", 15.99),
				new Producto("Goma 25 metros", 12.90),
				new Producto("Valvula Cierre", 10.70),
				new Producto("Conexión T", 8.50)
				)
		.flatMap(producto -> {
			producto.setCreateAt(new Date());
			return dao.save(producto);
		})
		.subscribe(producto -> log.info("Insert: " + producto.getId() + " " + producto.getNombre()));
		
	}

}
