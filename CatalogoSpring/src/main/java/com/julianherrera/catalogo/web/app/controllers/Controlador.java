package com.julianherrera.catalogo.web.app.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.julianherrera.catalogo.web.app.models.entity.Cliente;

@Controller
public class Controlador {
	

	/**
	 * *************************************************************************************
	 * GESTION DE LOGUEO 
	 * *************************************************************************************
	 */
	
	
	//Metodo que recibe de la vista el usuario y la clave y se Busca en la base de datos
	@RequestMapping(value = "/login")
	public String login(Map<String,Object> model) {
				
		Cliente cliente= new Cliente();
		
		model.put("cliente", cliente);
		
		model.put("titulo", "Cliente");
		model.put("ingresar", "  Ingresar");
					
		return "login";
	
	}
	

	/**
	 * ***********************************************************************************
	 * GESTION DE PAGINA DE INICIO
	 * ***********************************************************************************
	 */

	//Metodo de la pagina principal
	@RequestMapping({"/index","/","","/home"})
	public String index( Model model) {
		
		
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
			model.addAttribute("cantidadCarrito", 0);

		
		
		return "index";
		
	}
	
	//Metodo de la pagina principal
		@RequestMapping({"/index/{clienteId}"})
		public String indexLog(@PathVariable(value="clienteId") Long clienteId, Model model) {
			
			
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
			
			if(clienteId==null) {
				model.addAttribute("ingresar", "  Ingresar");
				model.addAttribute("cantidadCarrito", 0);
			}else {
				
				model.addAttribute("cantidadCarrito", 3 );
				model.addAttribute("ingresar","JULIAN" );
			}
			
			
			
			return "index";
			
		}
	
	

}
