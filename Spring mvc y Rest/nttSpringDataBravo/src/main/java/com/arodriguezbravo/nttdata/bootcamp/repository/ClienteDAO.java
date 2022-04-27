package com.arodriguezbravo.nttdata.bootcamp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arodriguezbravo.nttdata.bootcamp.models.entity.Cliente;

/**
 * Dao de cliente
 * @author bravo
 *
 */
@Repository
public interface ClienteDAO extends JpaRepository<Cliente, Long> {
	

	
	/**
	 * Busca por nombre de cliente
	 * @param name nombre a buscar
	 * @return devuelve el nombre de cliente, en otro caso null
	 */
	public Cliente findByName(String name);
	
	/**
	 * Busca por nombre y segundo apellido
	 * @param name nombre a buscar de cliente
	 * @param lastName apellido a buscar de cliente
	 * @return devuelve el nombre y primer apellido de cliente, null en caso contrario
	 */
	public List<Cliente> findByNameAndLastName(String name, String lastName);
	
	

}
