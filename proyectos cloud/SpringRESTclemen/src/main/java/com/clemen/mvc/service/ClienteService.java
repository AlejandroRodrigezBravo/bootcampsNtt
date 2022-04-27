package com.clemen.mvc.service;

import com.clemen.mvc.entity.Cliente;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ClienteService {

	Cliente guardarCliente(Cliente cliente);

	List<Cliente> verTodosClientes();

	List<Cliente> buscarNombreApellidos(String nombre, String apellido);

	ResponseEntity<String> borrarCliente(Long id);

	Cliente buscarPorId(Long id);

	Cliente crearCliente(Cliente cliente);

	Cliente actualizarCliente(Cliente cliente);
}
