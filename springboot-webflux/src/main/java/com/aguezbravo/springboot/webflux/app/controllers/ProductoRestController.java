package com.aguezbravo.springboot.webflux.app.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aguezbravo.springboot.webflux.app.dao.ProductoDao;
import com.aguezbravo.springboot.webflux.app.models.documents.Producto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/productos")
public class ProductoRestController {
	
	@Autowired
	private ProductoDao dao;
	
	private static final Logger log = LoggerFactory.getLogger(ProductoRestController.class);
	
	@GetMapping
	public Flux<Producto> index(){
		
		return dao.findAll().map(producto -> {
			producto.setNombre(producto.getNombre().toUpperCase());
			return producto;
		}).doOnNext(prod -> log.info(prod.getNombre()));
	}
	
	@GetMapping("/{id}")
	public Mono<Producto> show(@PathVariable String id){
		
		//Mono<Producto> producto = dao.findById(id);
		Flux<Producto> productos = dao.findAll();
		return productos.filter(p -> p.getId().equals(id))
				.next()
				.doOnNext(prod -> log.info(prod.getNombre()));
		
	}

}
