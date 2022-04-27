package com.arodriguezbravo.nttdata.bootcamp;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.arodriguezbravo.nttdata.bootcamp.models.entity.Cliente;
import com.arodriguezbravo.nttdata.bootcamp.service.IClienteService;

import lombok.extern.log4j.Log4j2;


@SpringBootApplication
@Log4j2
public class NTTDataAppBravo implements CommandLineRunner {

	@Autowired
	private IClienteService servicioCliente;

	public static void main(String[] args) {
		SpringApplication.run(NTTDataAppBravo.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Creacion de cliente 1
		Cliente cliente1 = new Cliente();
		cliente1.setId(1L);
		cliente1.setName("Alejandro");
		cliente1.setFirstName("Rodríguez");
		cliente1.setLastName("Bravo");
		cliente1.setDni("12345678V");
		cliente1.setCreateAt(new Date());

		// insert cliete 1
		servicioCliente.guardarCliente(cliente1);
		log.info("Insertando cliente 1 " + servicioCliente.guardarCliente(cliente1));

		// Creacion de cliente 2
		Cliente cliente2 = new Cliente();
		cliente2.setId(2L);
		cliente2.setName("Antonio");
		cliente2.setFirstName("Garcia");
		cliente2.setLastName("Rebollo");
		cliente2.setDni("16745678V");
		cliente2.setCreateAt(new Date());
		
		// insert cliete 2
		servicioCliente.guardarCliente(cliente2);
		log.info("Insertando cliente 2 " + servicioCliente.guardarCliente(cliente2));

		// Creacion de cliente 3
		Cliente cliente3 = new Cliente();
		cliente3.setId(3L);
		cliente3.setName("Juan");
		cliente3.setFirstName("Ocaña");
		cliente3.setLastName("Fernandez");
		cliente3.setDni("12005678V");
		cliente3.setCreateAt(new Date());

		// insert cliete 3
		servicioCliente.guardarCliente(cliente3);
		log.info("Insertando cliente 3 " + servicioCliente.guardarCliente(cliente3));

		System.out.println("********************");
		
		
		log.info("buscando a todos " + servicioCliente.buscarTodo());
		List<Cliente> listaClientes = servicioCliente.buscarTodo();
		log.info("añadiendo valor a lista " + listaClientes);
		
		for(Cliente c : listaClientes) {
			System.out.println(c.getName());
			log.info("Bucle for mejorado " + c);
		}
		
		System.out.println("********************");

	}

}
