package com.clemen.mvc.service.impl;

import com.clemen.mvc.entity.Cliente;
import com.clemen.mvc.repository.ClienteRepository;
import com.clemen.mvc.service.ClienteService;
import org.aspectj.apache.bcel.ExceptionConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {


	@Autowired
	ClienteRepository clienteRepository;

	@Override
	public Cliente guardarCliente(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}

	@Override
	public List<Cliente> verTodosClientes() {
		return this.clienteRepository.findAll();
	}

	@Override
	public List<Cliente> buscarNombreApellidos(String nombre, String apellido) {
		return this.clienteRepository.findByNombreAndApellidos(nombre, apellido);
	}

	@Override
	public ResponseEntity<String> borrarCliente(Long id){
		Cliente cliente = buscarPorId(id);
		try {
			if(cliente==null)
				return new ResponseEntity<>("Cliente: " + id + " no encontrado", HttpStatus.OK);

			this.clienteRepository.delete(cliente);

			return new ResponseEntity<>("Cliente: " + cliente.getId() + " borrado correctamente", HttpStatus.OK);
		} catch (final Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Error e:" + e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Override
	public Cliente buscarPorId(Long id) {
		return clienteRepository.findById(id).orElse(null);
	}


	@Override
	public Cliente crearCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@Override
	public Cliente actualizarCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

}
