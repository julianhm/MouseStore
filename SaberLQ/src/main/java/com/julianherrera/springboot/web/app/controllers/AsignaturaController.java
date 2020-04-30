package com.julianherrera.springboot.web.app.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.julianherrera.springboot.web.app.models.entity.Asignatura;
import com.julianherrera.springboot.web.app.models.service.IAreaService;
import com.julianherrera.springboot.web.app.models.service.IAsignaturaService;
import com.julianherrera.springboot.web.app.util.paginator.PageRender;

@Controller
@SessionAttributes("asignatura")
public class AsignaturaController {
	

	@Autowired
	private IAsignaturaService asignaturaService;
	
	@Autowired
	private IAreaService areaService;
		
	@Value("${texto.docentecontroller.docente.titulo}")
	private String titulo;
	
	@Value("${texto.Asignaturacontroller.asignatura.tituloGuardar}")
	private String tituloGuardar;
	
	@Value("${texto.Asignaturacontroller.asignatura.tituloGuardarTabla}")
	private String tituloTabla;
	
	@Value("${texto.Asignaturacontroller.asignatura.mensajeflashguardar}")
	private String mensajeFlashGuardar;
	
	@Value("${texto.Asignaturacontroller.asignatura.mensajeflasheliminar}")
	private String mensajeFlashEliminar;
	
	@Value("${texto.Asignaturacontroller.asignatura.mensajeflasheliminarError}")
	private String mensajeFlashEliminarError;
	
	@GetMapping(value = "/crearAsignatura")
	public String crear(Map<String, Object> model, RedirectAttributes flash) {

		Asignatura asignatura = new Asignatura();
				
		model.put("asignatura", asignatura);
		model.put("areas", areaService.findAll());
		model.put("titulo", tituloGuardar);
		model.put("titulotabla", tituloTabla);
		
		return "admin/crearAsignatura";
	}
	
	@PostMapping("/crearAsignatura")
	public String Guardar(@Valid Asignatura asignatura, BindingResult result, Model model,
			 RedirectAttributes flash, SessionStatus status) {

		if (result.hasErrors()) {
			flash.addFlashAttribute("error", mensajeFlashEliminarError);
			model.addAttribute("areas", areaService.findAll());
			model.addAttribute("titulo", tituloGuardar);
			
			return "admin/crearAsignatura";
		}
		
				
		asignaturaService.save(asignatura);
		status.setComplete();
		flash.addFlashAttribute("success", mensajeFlashGuardar);
		
		return "redirect:crearAsignatura";

	}
	
	@PostMapping("/crearAsignatura/{id}")
	public String editarArea(@PathVariable(value = "id") Long id, Map<String, Object> model,
			RedirectAttributes flash) {

		Asignatura asignatura = null;

		if (id > 0) {
			asignatura = asignaturaService.findOne(id);
			if (asignatura == null) {
				flash.addFlashAttribute("error", "Area no encontrada");
				
				return "redirect:/crearAsignatura";
			}
		} else {
			flash.addFlashAttribute("error", "Area no existe");
			
			return "redirect:/crearAsignatura";
		}

		model.put("asignatura", asignatura);
		model.put("titulo", tituloGuardar);

		return "admin/crearAsignatura";

	}
	
	@RequestMapping(value = "/eliminarAsignatura/{id}")
	public String eliminar(@PathVariable(name = "id") Long id, RedirectAttributes flash) {
		if (id > 0) {

			Asignatura asignatura =asignaturaService.findOne(id);
			if(asignatura!=null) {

				asignaturaService.delete(id);
			flash.addFlashAttribute("success", mensajeFlashEliminar);

			}else {
				flash.addFlashAttribute("error", mensajeFlashEliminarError);
			}
		}

		return "redirect:/crearAsignatura";
	}
	

	@ModelAttribute("page")
	public PageRender<Asignatura> page(@RequestParam(name = "page", defaultValue = "0") int page) {
		Pageable pageRequest = PageRequest.of(page, 4);

		Page<Asignatura> asignatura = asignaturaService.findAll(pageRequest);

		PageRender<Asignatura> pageRender = new PageRender<>("/crearAsignatura", asignatura);
		
		
		return pageRender;
	}
	
	@ModelAttribute("asignaturas")
	public Page<Asignatura> areas(@RequestParam(name = "page", defaultValue = "0") int page) {
		Pageable pageRequest = PageRequest.of(page, 4);

		Page<Asignatura> asignaturas = asignaturaService.findAll(pageRequest);

		
		
		
		return asignaturas;
	}

	@ModelAttribute("tituloprin")
	public String titulo() {
		return titulo;
	}
}
