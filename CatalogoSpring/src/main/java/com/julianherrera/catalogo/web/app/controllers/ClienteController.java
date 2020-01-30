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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.julianherrera.catalogo.web.app.models.entity.Cliente;
import com.julianherrera.catalogo.web.app.models.service.IClienteService;


@Controller
@SessionAttributes("cliente")
public class ClienteController {
	
	@Autowired
	public IClienteService clienteService;
	
	@RequestMapping(value = "/cliente",method = RequestMethod.GET)
	public String buscarCliente(Model model) {
		
		
		model.addAttribute("titulo", "Cliente");
		model.addAttribute("cliente",clienteService.bucarCliente());
		
		return "cliente";
		
	}

	
	@RequestMapping(value="/form")
	public String crearUsuario(Model model) {
		
		Cliente cliente = new Cliente();
		model.addAttribute("cliente",cliente);
		model.addAttribute("titulo", "Formulario de Cliente");
		
		
		return "gestionProductos";

	}
	
	@RequestMapping(value="/form", method = RequestMethod.POST)
	public String GuardarCliente(@Validated Cliente cliente, BindingResult result, Model model, SessionStatus status) {
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Cliente");
			return "registrocliente";
		}
		
		
		clienteService.crear(cliente);
		status.setComplete();
		
		
		return "redirect:index";
		
		
	}
	
	@RequestMapping(value="/gestionProductos/{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String,Object> model) {
		
		Cliente cliente = null;
		
		if(id>0) {
			cliente = clienteService.buscar(id);
		}else {
			return "redirect:/cliente";
		}
		
		model.put("cliente", cliente);
		model.put("titulo", "Editar Clinete");
		
		return "gestionProductos";
	}
	
	@RequestMapping(value="/eliminar/{id}")
	public String eliminarCliente(@PathVariable(value="id") Long id) {
	
		if(id>0) {
			clienteService.eliminar(id);
		}
		
		return "redirect:/cliente";
	}
	
	@RequestMapping({"/index","/","","/home"})
	public String index(Model model) {
		model.addAttribute("tituloprinc", "MOUSE STORE");
		model.addAttribute("titulo", "MOUSE STORE");
		model.addAttribute("inicioMenu", "INICIO");
		model.addAttribute("catalogoMenu", "CATALOGO");
		model.addAttribute("registroMenu", "REGISTRO");
		model.addAttribute("carritoMenu", "CARRITO");
		model.addAttribute("cantidadCarrito", 1);
		model.addAttribute("lema", "Confianza y Calidad");
		model.addAttribute("loMejor", "Los mejores Precios de Armenia");
		model.addAttribute("ultimo", "Ultimos Productos");
		model.addAttribute("boton", "Catalogo");
		model.addAttribute("descuentouno", "30% menos");
		model.addAttribute("textouno", "En Diademas");
		model.addAttribute("comprar", "Comprar Ahora");
		model.addAttribute("descuentodos", "25% menos");
		model.addAttribute("textodos", "En Mini Teclados");
		model.addAttribute("descuentotres", "20% menos");
		model.addAttribute("textotres", "En Todos los Mouse");
		model.addAttribute("ingresar", "  Ingresar");
		
		
		return "index";
		
	}
	
	@RequestMapping(value="/cart", method= RequestMethod.GET)
	public String carrito(Model model) {
	
		
		
		
		
		return "carrito";
		
	}
	
	@RequestMapping(value="/store", method= RequestMethod.GET)
	public String catalogo(Model model) {
		model.addAttribute("tituloprinc", "MOUSE STORE");
		model.addAttribute("titulo","Catálogo");
		model.addAttribute("inicioMenu", "INICIO");
		model.addAttribute("catalogoMenu", "CATALOGO");
		model.addAttribute("registroMenu", "REGISTRO");
		model.addAttribute("carritoMenu", "CARRITO");
		model.addAttribute("cantidadCarrito", 1);
		model.addAttribute("ingresar", "Ingresar");
		
		
		
		return "categorias";
		
	}
	
	@RequestMapping(value="/registro")
	public String registroCliente( Model model) {
		model.addAttribute("tituloprinc", "MOUSE STORE");
		model.addAttribute("titulo","Registro");
		model.addAttribute("inicioMenu", "INICIO");
		model.addAttribute("catalogoMenu", "CATALOGO");
		model.addAttribute("registroMenu", "REGISTRO");
		model.addAttribute("carritoMenu", "CARRITO");
		model.addAttribute("cantidadCarrito", 1);
		model.addAttribute("ingresar", "Ingresar");
		
		Cliente cliente = new Cliente();
		model.addAttribute("cliente",cliente);
		
		
		
		return "registroCliente";
		
		
		
		
	}

}
