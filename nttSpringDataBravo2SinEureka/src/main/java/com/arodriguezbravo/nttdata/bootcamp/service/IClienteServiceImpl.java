package com.arodriguezbravo.nttdata.bootcamp.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arodriguezbravo.nttdata.bootcamp.models.entity.Cliente;
import com.arodriguezbravo.nttdata.bootcamp.repository.ClienteDAO;

/**
 * Implementación del servicio de cliente
 * 
 * @author bravo
 *
 */
@Service
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
		return listaNombreCompleto;
	}

	@Override
	@Transactional
	public List<Cliente> buscarTodo() {
		List<Cliente> listaCompleta = clienteDAO.findAll();
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

	@Override
	public Cliente findOne(Long id) {
		return clienteDAO.findById(id).orElse(null);
	}

	@Override
	public Cliente actualizarCliente(Long id, Cliente cliente) {
		Cliente old = clienteDAO.findById(id).orElse(null);
		
		try {
			if(old.getId() != null) {
				old.setName(cliente.getName());
				old.setFirstName(cliente.getFirstName());
				old.setLastName(cliente.getLastName());
				old.setDni(cliente.getDni());
				old.setCreateAt(cliente.getCreateAt());
				clienteDAO.save(old);
			} else {
				old = clienteDAO.save(cliente);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return old;
	}

}
