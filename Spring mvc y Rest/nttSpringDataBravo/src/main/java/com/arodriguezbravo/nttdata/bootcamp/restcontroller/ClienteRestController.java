package com.arodriguezbravo.nttdata.bootcamp.restcontroller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.arodriguezbravo.nttdata.bootcamp.models.entity.Cliente;
import com.arodriguezbravo.nttdata.bootcamp.service.IClienteService;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api/clientes")
@Log4j2
public class ClienteRestController {

	@Autowired
	private IClienteService servicioCliente;

	@GetMapping()
	@ResponseBody
	public ResponseEntity<List<Cliente>> get() {
		ResponseEntity<List<Cliente>> res;

		try {
			// Devolver elemento
			res = ResponseEntity.ok().body(servicioCliente.buscarTodo());
		} catch (Exception ex) {
			log.error(ex);
			res = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

		return res;
	}
	
	@GetMapping("/buscar")
	@ResponseBody
	public ResponseEntity<Cliente> getCliente(@RequestParam String nombre) {
		ResponseEntity<Cliente> res;

		try {
			// Devolver elemento
			res = ResponseEntity.ok().body(servicioCliente.buscarNombre(nombre));
		} catch (Exception ex) {
			log.error(ex);
			res = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

		return res;
	}
	
	@PostMapping()
	public ResponseEntity<Cliente> post(@RequestBody @Valid Cliente item, BindingResult result) {
		ResponseEntity<Cliente> res;

		try {
			// Crear elemento
			res = ResponseEntity.ok().body(servicioCliente.guardarCliente(item));
		} catch (Exception ex) {
			log.error(ex);
			res = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

		return res;
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Cliente> delete(@PathVariable("id") Long id) {
		ResponseEntity<Cliente> res;

		try {
			// Eliminar elemento
			servicioCliente.eliminar(id);
			res = ResponseEntity.ok().build();
		} catch (Exception ex) {
			log.error(ex);
			res = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

		return res;
	}
	
	

}
