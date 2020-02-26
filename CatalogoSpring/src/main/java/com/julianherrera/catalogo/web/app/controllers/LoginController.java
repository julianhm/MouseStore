package com.julianherrera.catalogo.web.app.controllers;

import java.security.Principal;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.julianherrera.catalogo.web.app.models.entity.Cliente;

@Controller
public class LoginController {
	

	/**
	 * *************************************************************************************
	 * GESTION DE LOGUEO 
	 * *************************************************************************************
	 */
	
	
	
	@RequestMapping(value = "/login")
	public String login(@RequestParam(value="error", required = false) String error,
			@RequestParam(value="logout", required = false) String logout,
			Model model, Principal principal,RedirectAttributes flash) {
		
			
		
		if(principal!=null) {
			flash.addFlashAttribute("info", "Ya ha inicado Sesion activa");	
			return "redirect: /";
		}
		
		if(error!=null) {
			model.addAttribute("error", "Error en el login nombre de usuario o contraseña incorrecta, por favor vuelva a intentar");
		}
		
		if(logout!=null) {
			model.addAttribute("sucess", "Ha cerrado sesion con exito");
		}
					
		return "login";
	
	}
	

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
