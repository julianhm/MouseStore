package com.julianherrera.springboot.web.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.julianherrera.springboot.web.app.models.entity.Docente;




@Controller
public class IndexController {
	
	
	
	@Value("${texto.indexcontroller.index.titulo}")
	private String textoHola;
	
	@GetMapping(value = "/index")
	public String index(Model model) {
		model.addAttribute("titulo", textoHola);
		return "index";
		
	}
	
	@GetMapping(value="/perfil")
	public String perfil(Model model) {
		Docente usuario= new Docente();
		usuario.setNombre("Julian");
		usuario.setApellido("Herrera");
		model.addAttribute("usuario",usuario);
		model.addAttribute("titulo", textoHola);
		
		
		return "perfil";
	}

}
