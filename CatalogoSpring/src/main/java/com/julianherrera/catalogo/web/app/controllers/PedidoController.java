package com.julianherrera.catalogo.web.app.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.julianherrera.catalogo.web.app.models.entity.Cliente;
import com.julianherrera.catalogo.web.app.models.entity.Producto;
import com.julianherrera.catalogo.web.app.models.service.IClienteService;
import com.julianherrera.catalogo.web.app.models.service.IPedidoService;

@Controller
@RequestMapping("/pedido")
public class PedidoController {
	@Autowired
	public IPedidoService pedidoService;
	
	
	
	
	/**
	 * **************************************************************************************
	 * GESTION DE CLIENTES  Y PRODUCTOS DESDE ADMIN
	 * **************************************************************************************
	 */
	
	
	//Metodo que me permito buscar todos los Clientee y enviarlo a la vista cliente
	@RequestMapping(value = "/carrito/{clienteId}",method = RequestMethod.POST)
	public String buscarPedido(@PathVariable(value="clienteId") Long clienteId,Model model) {
		
		model.addAttribute("ingresar", "  Ingresar");
		model.addAttribute("titulo", "Cliente");
		model.addAttribute("cliente",pedidoService.buscar(clienteId));
		
		return "redirect:/pedido/carrito";
		
	}
	
	@RequestMapping(value="/eliminarpedido/{clienteId}/{id}")
	public String eliminarPedido(@PathVariable(value="clienteId") Long clienteId,@PathVariable(value="id") Long id) {
	
		if(id>0) {
			pedidoService.eliminar(id);
		}
		
		return "redirect:/pedido/carrito/"+clienteId;
	}
	

	//Metodo que permite ir a la pagina para crear un nuevo producto
	@RequestMapping(value="/crearPedido/{clienteId}")
	public String crearPedido(@PathVariable(value="clienteId") Long clienteId, Model model) {
		
		Producto producto = new Producto();
		model.addAttribute("producto",producto);
		model.addAttribute("titulo", "Formulario de Productos");

		model.addAttribute("cantidadCarrito", 0);
		model.addAttribute("tituloPrin", "Productos");
		model.addAttribute("ingresar", "  Administrador");
		
		
		return "redirect:/pedido/carrito/"+clienteId;

	}
	


}
