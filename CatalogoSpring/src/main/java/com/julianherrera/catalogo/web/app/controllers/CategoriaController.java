package com.julianherrera.catalogo.web.app.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		
		Categoria categoria = new Categoria();
		
		model.addAttribute("titulo","Agregar Categorias");
		model.addAttribute("categoria",categoria);
		
		model.addAttribute("todasCategorias",categoriaService.bucarCategoria());
	
		
		return "categoria/gestionCategoria";
		
	}
	
	@RequestMapping(value="/form", method= RequestMethod.POST)
	public String crearCategoria(@Valid Categoria categoria, BindingResult result,Model model, RedirectAttributes flash, SessionStatus status) {
		
		if(result.hasErrors()) {
			model.addAttribute("titulo","Agregar Categorias");
			
			return "categoria/gestionCategoria";
		}
		
		categoriaService.crear(categoria);
		status.setComplete();
		
		flash.addFlashAttribute("success", "categoria creado con exito");
		
		return "redirect:/categoria/form";

	}
	
	
	@GetMapping(value="/eliminarcliente/{id}")
	public String eliminarCategoria(@PathVariable(value="id") Long id) {
	
		if(id>0) {
			categoriaService.eliminar(id);
		}
		
		return "redirect:/categoria/gestionCategoria";
	}
	

	
	
	
		
	
	
	
	
}
