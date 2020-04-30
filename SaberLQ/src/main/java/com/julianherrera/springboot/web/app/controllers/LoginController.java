package com.julianherrera.springboot.web.app.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.julianherrera.springboot.web.app.models.entity.Login;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String login(Model model) {
		Login login= new Login();
		model.addAttribute("login", login);
		
		return "login";
		
	}
	
	
	@PostMapping("/login")
	public String Validar(@Valid Login login, BindingResult result, Model model) {
		
		
		if(result.hasErrors()) {
			
			return "login";
		}
		
		model.addAttribute("login", login);
		
		
		return "validar";
		
	}

}
