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


import com.julianherrera.catalogo.web.app.models.entity.Producto;

import com.julianherrera.catalogo.web.app.models.service.IProductoService;


@Controller
@RequestMapping("/admin")
@SessionAttributes("producto")
public class ProductoController {
	
	@Autowired
	public IProductoService productoService;
	
	@RequestMapping(value = "/listarProductos",method = RequestMethod.GET)
	public String buscarProducto(Model model) {
		
		model.addAttribute("tituloprinc", "MOUSE STORE");
		
		model.addAttribute("inicioMenu", "INICIO");
		model.addAttribute("catalogoMenu", "CATALOGO");
		model.addAttribute("registroMenu", "REGISTRO");
		model.addAttribute("carritoMenu", "CARRITO");
		model.addAttribute("cantidadCarrito", 1);
		model.addAttribute("titulo", "Cliente");
		model.addAttribute("ingresar", "  Ingresar");
		model.addAttribute("cliente",productoService.bucarProducto());
		
		return "gestionProductos";
		
	}

	
	@RequestMapping(value="/product")
	public String crearProducto(Model model) {
		
		Producto producto = new Producto();
		model.addAttribute("producto",producto);
		model.addAttribute("titulo", "Formulario de Productos");
		model.addAttribute("inicioMenu", "INICIO");
		model.addAttribute("catalogoMenu", "CATALOGO");
		model.addAttribute("registroMenu", "REGISTRO");
		model.addAttribute("carritoMenu", "CARRITO");
		model.addAttribute("cantidadCarrito", 1);
		model.addAttribute("tituloPrin", "Productos");
		model.addAttribute("ingresar", "  Ingresar");
		
		
		return "gestionProductos";

	}
	
	@RequestMapping(value="/product", method = RequestMethod.POST)
	public String GuardarProducto(@Validated Producto producto, BindingResult result, Model model, SessionStatus status) {
		if(result.hasErrors()) {
			Producto producto1 = new Producto();
			model.addAttribute("producto",producto1);
			model.addAttribute("titulo", "Formulario de Productos");
			model.addAttribute("inicioMenu", "INICIO");
			model.addAttribute("catalogoMenu", "CATALOGO");
			model.addAttribute("registroMenu", "REGISTRO");
			model.addAttribute("carritoMenu", "CARRITO");
			model.addAttribute("cantidadCarrito", 1);
			model.addAttribute("tituloPrin", "Productos");
			model.addAttribute("ingresar", "  Ingresar");
			
			return "gestionProductos";
		}
		
		
		productoService.crear(producto);
		status.setComplete();
		
		
		return "redirect:/gestionProductos";
		
		
	}
	
	@RequestMapping(value="/gestionProductos/{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String,Object> model) {
		
		Producto producto = null;
		
		if(id>0) {
			producto = productoService.buscar(id);
		}else {
			return "redirect:/gestionProductos";
		}
		
		model.put("producto", producto);
		model.put("titulo", "Editar Producto");
		
		return "gestionProductos";
	}
	
	@RequestMapping(value="/eliminar/{id}")
	public String eliminarProducto(@PathVariable(value="id") Long id) {
	
		if(id>0) {
			productoService.eliminar(id);
		}
		
		return "redirect:/gestionProductos";
	}
	
	

}
