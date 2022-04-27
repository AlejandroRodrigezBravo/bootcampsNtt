package com.arodriguezbravo.nttdata.bootcamp.service;

import java.util.List;

import com.arodriguezbravo.nttdata.bootcamp.models.entity.Cliente;

/**
 * Funcionalidad de cliente
 * 
 * @author bravo
 *
 */
public interface IClienteService {

	/**
	 * Busca por cliente.
	 * 
	 * @param name nombre a buscar.
	 * @return devuelve el nombre cliente.
	 */
	public List<Cliente> buscarNombre(String name);

	/**
	 * Buscar por nombre y segundo apellido.
	 * 
	 * @param name     nombre a buscar
	 * @param lastName apellido a buscar
	 * @return devuelve el nombre y segundo apellido de cliente.
	 */
	public List<Cliente> buscarNombreCompleto(String name, String lastName);

	/**
	 * Busca la lista de cliente.
	 * 
	 * @return List<Cliente>
	 */
	public  List<Cliente> buscarTodo();
	
	/**
	 * Guarda un cliente
	 * 
	 * @param cliente a guardar
	 */
	public Cliente guardarCliente(Cliente cliente);

	/**
	 * Eliminar cliente
	 * 
	 * @param id para buscar cliente
	 */
	public void eliminar(Long id);

}
