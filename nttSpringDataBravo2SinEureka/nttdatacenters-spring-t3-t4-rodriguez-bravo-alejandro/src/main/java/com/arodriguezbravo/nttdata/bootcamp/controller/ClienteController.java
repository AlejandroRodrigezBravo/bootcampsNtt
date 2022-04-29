package com.arodriguezbravo.nttdata.bootcamp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;
import com.arodriguezbravo.nttdata.bootcamp.models.entity.Cliente;
import com.arodriguezbravo.nttdata.bootcamp.service.IClienteService;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class ClienteController {

	@Autowired
	private IClienteService clienteService;
	
	

	/**
	 * Ejemplo de solicitud con respuesta hacia vista.
	 * 
	 * Resultada al formulario de matriculación.
	 * 
	 * @return String
	 * @throws Exception
	 */

	/*
	 * @GetMapping("/ver") public String ver(@Valid @ModelAttribute("cliente")
	 * Cliente cliente, Model model, BindingResult br) {
	 * 
	 * String nombre = StringUtils.substring(cliente.getName(), 0, 1); String
	 * firtsName = StringUtils.substring(cliente.getFirstName(), 0, 1); String
	 * lastName = StringUtils.substring(cliente.getLastName(), 0, 1);
	 * cliente.setName(nombre); cliente.setName(firtsName);
	 * cliente.setName(lastName);
	 * 
	 * return "/mostrar"; }
	 */

	/*
	 * 
	 * @GetMapping("/ver") public String ver(Model model, Cliente cliente) {
	 * 
	 * Cliente listaCliente = clienteservice.buscar(cliente.getName());
	 * model.addAttribute("listaCliente",listaCliente);
	 * 
	 * return "mostrar";
	 * 
	 * }
	 */

	@GetMapping("/ver")
	public String ver(Model model, Cliente cliente) {

		List<Cliente> cl = new ArrayList<>();
		
		cl.addAll(clienteService.buscarTodo());
		
		log.info("Es: " + clienteService.buscarTodo());
		
		model.addAttribute("listaCliente", cl);
		
		log.info("Es: " + model.addAttribute("listaCliente", cl));
		
		return "mostrar";

	}

	@PostMapping("/eliminarCliente")
	public String deleteC(@RequestParam Long btnEliminar) throws Exception {

		clienteService.eliminar(btnEliminar);

		return "mostrar";

	}

	@ExceptionHandler(BindException.class)
	public String checkExceptions(BindingResult br) {

		// Resultado
		String output = "";

		// Verificación de errores.
		if (br.hasErrors()) {

			output = "/showErrorView";

		}

		return output;
	}

}
