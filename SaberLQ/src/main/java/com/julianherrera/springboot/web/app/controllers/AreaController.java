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

import com.julianherrera.springboot.web.app.models.entity.Area;

import com.julianherrera.springboot.web.app.models.service.IAreaService;
import com.julianherrera.springboot.web.app.util.paginator.PageRender;




@Controller
@SessionAttributes("area")
public class AreaController {
	
	@Autowired
	private IAreaService areaService;
	
	@Value("${texto.docentecontroller.docente.titulo}")
	private String titulo;
		
	@Value("${texto.Areacontroller.area.tituloGuardarArea}")
	private String tituloGuardar;
	
	@Value("${texto.Areacontroller.area.tituloGuardarTabla}")
	private String tituloTabla;
	
	@Value("${texto.Areacontroller.area.mensajeflashguardarArea}")
	private String mensajeFlashGuardar;
	
	@Value("${texto.Areacontroller.area.mensajeflasheliminarArea}")
	private String mensajeFlashEliminar;
	
	@Value("${texto.Areacontroller.area.mensajeflasheliminarAreaError}")
	private String mensajeFlashEliminarError;
	
	@GetMapping(value = "/crearArea")
	public String crearDocente(Map<String, Object> model) {

		
		
		Area area = new Area();
		
		
		model.put("area", area);
		
		model.put("titulo", tituloGuardar);
		model.put("titulotabla", tituloTabla);
		
		return "admin/crearArea";
	}
	
	@PostMapping("/crearArea")
	public String Guardar(@Valid Area area, BindingResult result, Model model,
			 RedirectAttributes flash, SessionStatus status) {

		if (result.hasErrors()) {
			model.addAttribute("titulo", tituloGuardar);
			return "admin/crearArea";
		}
		
				
		areaService.save(area);
		status.setComplete();
		flash.addFlashAttribute("success", mensajeFlashGuardar);
		
		return "redirect:crearArea";

	}
	
	@PostMapping("/crearArea/{id}")
	public String editarArea(@PathVariable(value = "id") Long id, Map<String, Object> model,
			RedirectAttributes flash) {

		Area area = null;

		if (id > 0) {
			area = areaService.findOne(id);
			if (area == null) {
				flash.addFlashAttribute("error", "Area no encontrada");
				
				return "redirect:/crearArea";
			}
		} else {
			flash.addFlashAttribute("error", "Area no existe");
			
			return "redirect:/crearArea";
		}

		model.put("area", area);
		model.put("titulo", tituloGuardar);

		return "admin/crearArea";

	}
	
	@RequestMapping(value = "/eliminarArea/{id}")
	public String eliminar(@PathVariable(name = "id") Long id, RedirectAttributes flash) {
		if (id > 0) {

			Area area =areaService.findOne(id);
			if(area!=null) {

			areaService.delete(id);
			flash.addFlashAttribute("success", mensajeFlashEliminar);

			}else {
				flash.addFlashAttribute("error", mensajeFlashEliminarError);
			}
		}

		return "redirect:/crearArea";
	}
	
	@ModelAttribute("page")
	public PageRender<Area> page(@RequestParam(name = "page", defaultValue = "0") int page) {
		Pageable pageRequest = PageRequest.of(page, 4);

		Page<Area> areas = areaService.findAll(pageRequest);

		PageRender<Area> pageRender = new PageRender<>("/crearArea", areas);
		
		
		return pageRender;
	}
	
	@ModelAttribute("areas")
	public Page<Area> areas(@RequestParam(name = "page", defaultValue = "0") int page) {
		Pageable pageRequest = PageRequest.of(page, 4);

		Page<Area> areas = areaService.findAll(pageRequest);

		
		
		
		return areas;
	}

	@ModelAttribute("tituloprin")
	public String titulo() {
		return titulo;
	}
}
