package com.arodriguezbravo.nttdata.bootcamp.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.arodriguezbravo.nttdata.bootcamp.models.entity.Cliente;
import com.arodriguezbravo.nttdata.bootcamp.service.IClienteService;

@Controller
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
	@RequestMapping(value = "/ver" , method = RequestMethod.GET)
	public String mostrar(Model model, Cliente cliente) {

		List<Cliente> cl = new ArrayList<>();

		cl.addAll(clienteService.buscarTodo());

		model.addAttribute("listaCliente", cl);

		return "mostrar";

	}
	
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String guardar(Cliente cliente, Model model) {
		clienteService.guardarCliente(cliente);
		return "mostrar";
		
	}
	
	@RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
	public String eliminar(@PathVariable(value = "id") Long id) {
		clienteService.eliminar(id);
		return "redirect:/mostrar";

	}


}
