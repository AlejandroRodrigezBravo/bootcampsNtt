package com.arodriguezbravo.nttdata.bootcamp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional
	public Cliente buscarNombre(String name) {
		Cliente cliente = clienteDAO.findByName(name);
		return cliente;
	}

	@Override
	@Transactional
	public List<Cliente> buscarNombreCompleto(String name, String lastName) {

		List<Cliente> listaNombreCompleto = clienteDAO.findByNameAndLastName(name, lastName);
		log.info("listaNombreCompleto " + clienteDAO.findByNameAndLastName(name, lastName));
		return listaNombreCompleto;
	}

	@Override
	@Transactional
	public List<Cliente> buscarTodo() {
		List<Cliente> listaCompleta = clienteDAO.findAll();
		log.info("listaCompleta" + clienteDAO.findAll());
		return listaCompleta;
	}

	@Override
	@Transactional
	public Cliente guardarCliente(Cliente cliente) {
			cliente = clienteDAO.save(cliente);
		return cliente;

	}

	@Override
	@Transactional
	public void eliminar(Long id) {
		clienteDAO.deleteById(id);
	}

}
