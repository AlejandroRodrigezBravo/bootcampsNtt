package com.arodriguezbravo.nttdata.bootcamp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.arodriguezbravo.nttdata.bootcamp.models.entity.Cliente;
import com.arodriguezbravo.nttdata.bootcamp.service.IClienteService;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class ClienteController {

	@Autowired
	private IClienteService clienteService;

	@RequestMapping(value = { "/ver", "/" }, method = RequestMethod.GET)
	public String mostrar(Model model, Cliente cliente) {

		List<Cliente> cl = new ArrayList<>();

		cl.addAll(clienteService.buscarTodo());

		model.addAttribute("listaCliente", cl);

		return "/mostrar";

	}

	@RequestMapping(value = "/form")
	public String crear(Map<String, Object> model) {

		Cliente cliente = new Cliente();
		model.put("cliente", cliente);
		model.put("titulo", "Crear Cliente");
		return "form";
	}

	@RequestMapping(value = "/edit/{id}")
	public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model) {

		Cliente cliente = null;

		if (id > 0) {
			cliente = clienteService.findOne(id);
			if (cliente == null) {
				return "redirect:/mostrar";
			}
		} else {
			return "redirect:/mostrar";
		}
		model.put("cliente", cliente);
		model.put("titulo", "Editar Cliente");
		return "form";
	}

	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String guardar(Cliente cliente, Model model) {
		clienteService.guardarCliente(cliente);
		return "redirect:mostrar";

	}

	@RequestMapping(value = "/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Long id) {

		Cliente cliente = clienteService.findOne(id);

		if (cliente.getId() > 0) {
			log.info("Entra en el id : " + id);

			log.info("Busca en el id : " + id);
			clienteService.eliminar(id);
			log.info("Elimina en el id : " + id);
		}

		return "redirect:/mostrar";

	}

}
