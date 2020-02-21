package com.julianherrera.catalogo.web.app.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.julianherrera.catalogo.web.app.models.entity.Cliente;
import com.julianherrera.catalogo.web.app.models.entity.Producto;
import com.julianherrera.catalogo.web.app.models.service.IClienteService;
import com.julianherrera.catalogo.web.app.models.service.IPedidoService;
import com.julianherrera.catalogo.web.app.models.service.IProductoService;



@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	public IClienteService clienteService;
	
	
	
	
	/**
	 * **************************************************************************************
	 * GESTION DE CLIENTES DESDE ADMIN
	 * **************************************************************************************
	 */
	
	
	//Metodo que me permito buscar todos los Clientee y enviarlo a la vista cliente
	@RequestMapping(value = "/cliente",method = RequestMethod.GET)
	public String buscarClientes(Model model) {
		
		model.addAttribute("ingresar", "  Ingresar");
		model.addAttribute("titulo", "Cliente");
		model.addAttribute("cliente",clienteService.bucarCliente());
		
		return "cliente";
		
	}
	
	@RequestMapping(value="/eliminarcliente/{id}")
	public String eliminarCliente(@PathVariable(value="id") Long id) {
	
		if(id>0) {
			clienteService.eliminar(id);
		}
		
		return "redirect:/cliente";
	}
	


	
	
	//Metodo que recibe de la vista el usuario y la clave y se Busca en la base de datos
		@RequestMapping(value = "/login", method= RequestMethod.POST)
		public String buscarClienteCorreo(Cliente cliente, Model model) {
			
			if(cliente.getCorreo().equals("admin@admin.com")&&cliente.getClave().equals("admin123")) {
				return "redirect:/cliente";
			}
			
			Cliente miCliente= clienteService.buscarPorCorreo(cliente.getCorreo())	;
			
			if(cliente.getCorreo().equals(miCliente.getCorreo()) && cliente.getClave().equals(miCliente.getClave()) ) {
				cliente=miCliente;
				return "redirect:/index/"+cliente.getId();
			}
				return "redirect:/index";
			
				
			
			
		}
		
		
		
		/**
		 * ***********************************************************************************
		 * Gestion de Registro de un nuevo cliente
		 * **********************************************************************************
		 */

	//Envio a la pagina de registro, se crea una instancia de cliente y se envia
	@RequestMapping(value="/registro")
	public String crearCliente(Map<String,Object> model) {
		
		Cliente cliente = new Cliente();
		model.put("cliente",cliente);
		model.put("titulo", "Formulario de Cliente");
		model.put("ingresar", "  Ingresar");
		
		return "/cliente/registroCliente";

	}
	
	//Se recibe el cliente desde la vista y se almacena en base de datos
	@RequestMapping(value="/registro", method = RequestMethod.POST)
	public String GuardarCliente(@Validated Cliente cliente, BindingResult result, Model model, SessionStatus status) {
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Cliente");
			return "registroCliente";
		}
		
		
		clienteService.crear(cliente);
		status.setComplete();
		
		
		return "redirect:index";
		
		
	}
	
	
	
}
