package com.julianherrera.catalogo.web.app.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.julianherrera.catalogo.web.app.models.entity.Categoria;
import com.julianherrera.catalogo.web.app.models.entity.Cliente;
import com.julianherrera.catalogo.web.app.models.entity.Producto;
import com.julianherrera.catalogo.web.app.models.service.ICategoriaService;
import com.julianherrera.catalogo.web.app.models.service.IClienteService;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	public ICategoriaService categoriaService;
	
	
	
	
	/**
	 * **************************************************************************************
	 * GESTION DE CATEGORIAS DESDE ADMIN
	 * **************************************************************************************
	 */
	
	
	//Metodo que me permito buscar todos los Clientee y enviarlo a la vista cliente
	@GetMapping(value = "/form")
	public String buscarCategorias(Model model) {
		
		model.addAttribute("ingresar", "  Ingresar");
		model.addAttribute("titulo", "Cliente");
		model.addAttribute("cliente",categoriaService.bucarCategoria());
		
		return "categoria/gestionCategoria";
		
	}
	
	@GetMapping(value="/eliminarcliente/{id}")
	public String eliminarCategoria(@PathVariable(value="id") Long id) {
	
		if(id>0) {
			categoriaService.eliminar(id);
		}
		
		return "redirect:/categoria/gestionCategoria";
	}
	

	//Metodo que permite ir a la pagina para crear un nuevo producto
	@RequestMapping(value="/crear", method= RequestMethod.POST)
	public String crearCategoria(Model model) {
		
		Producto producto = new Producto();
		model.addAttribute("producto",producto);
		model.addAttribute("titulo", "Formulario de Productos");

		model.addAttribute("cantidadCarrito", 0);
		model.addAttribute("tituloPrin", "Productos");
		model.addAttribute("ingresar", "  Administrador");
		
		
		return "redirect:/categoria/gestionCategoria";

	}
	
	
		
	
	
	
	
}
