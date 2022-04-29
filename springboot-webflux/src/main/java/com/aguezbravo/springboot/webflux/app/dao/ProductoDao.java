package com.aguezbravo.springboot.webflux.app.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import com.aguezbravo.springboot.webflux.app.models.documents.Producto;

public interface ProductoDao extends ReactiveMongoRepository<Producto, String> {

}
