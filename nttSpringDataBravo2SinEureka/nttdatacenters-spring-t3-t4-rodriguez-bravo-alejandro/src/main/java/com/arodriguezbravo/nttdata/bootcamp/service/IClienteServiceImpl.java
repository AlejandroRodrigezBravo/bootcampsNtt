package com.arodriguezbravo.nttdata.bootcamp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arodriguezbravo.nttdata.bootcamp.models.entity.Cliente;
import com.arodriguezbravo.nttdata.bootcamp.repository.ClienteDAO;

import lombok.extern.log4j.Log4j2;

/**
 * Implementación del servicio de cliente
 * 
 * @author bravo
 *
 */
@Service
@Log4j2
public class IClienteServiceImpl implements IClienteService {

	@Autowired
	private ClienteDAO clienteDAO;

	@Override

	public List<Cliente> buscarNombre(String name) {
		List<Cliente> listaNombre = clienteDAO.findByName(name);
		log.info("listaNombre " + clienteDAO.findByName(name));
		return listaNombre;
	}

	@Override

	public List<Cliente> buscarNombreCompleto(String name, String lastName) {

		List<Cliente> listaNombreCompleto = clienteDAO.findByNameAndLastName(name, lastName);
		log.info("listaNombreCompleto " + clienteDAO.findByNameAndLastName(name, lastName));
		return listaNombreCompleto;
	}

	@Override
	
	public List<Cliente> buscarTodo() {
		List<Cliente> listaCompleta = clienteDAO.findAll();
		log.info("listaCompleta" + clienteDAO.findAll());
		return listaCompleta;
	}

	@Override
	
	public Cliente guardarCliente(Cliente cliente) {

		if (cliente != null && cliente.getId() == null) {
			cliente = clienteDAO.save(cliente);
		}
		return cliente;

	}

	@Override
	
	public void eliminar(Long id) {
		clienteDAO.deleteById(id);
	}

}
