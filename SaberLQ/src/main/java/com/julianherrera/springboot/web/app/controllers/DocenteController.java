package com.julianherrera.springboot.web.app.controllers;

import java.io.IOException;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.julianherrera.springboot.web.app.models.entity.Docente;

import com.julianherrera.springboot.web.app.models.service.IDocenteService;
import com.julianherrera.springboot.web.app.models.service.IUploadFileService;
import com.julianherrera.springboot.web.app.util.paginator.PageRender;

@Controller
@SessionAttributes("docente")
public class DocenteController {

	@Autowired
	private IDocenteService docenteService;

	@Autowired
	private IUploadFileService uploadFileService;

	@Value("${texto.docentecontroller.docente.titulo}")
	private String titulo;

	@Value("${texto.docentecontroller.docente.titulolistar}")
	private String tituloListar;

	@Value("${texto.docentecontroller.docente.tituloguardar}")
	private String tituloGuardar;

	@Value("${texto.docentecontroller.docente.tituloeditar}")
	private String tituloEditar;

	@Value("${texto.docentecontroller.docente.mensajeflashguardar}")
	private String mensajeFlashGuardar;

	@Value("${texto.docentecontroller.docente.mensajeflasheliminar}")
	private String mensajeFlashEliminar;

	@Value("${texto.docentecontroller.docente.mensajeflasheditar}")
	private String mensajeFlashEditar;

	@Value("${texto.docentecontroller.docente.mensajeflasheditarnoencontrado}")
	private String mensajeFlashEditarNoEncontrado;

	@Value("${texto.docentecontroller.listar.primera}")
	private String paginatorPrimera;

	@Value("${texto.docentecontroller.listar.ultima}")
	private String paginatorUltima;

	@Value("${texto.docentecontroller.guardar.foto}")
	private String mensajeFlashCargoFoto;

	@Value("${texto.docentecontroller.eliminar.foto}")
	private String mensajeFlashFotoEliminada;

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String listar(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {

		Pageable pageRequest = PageRequest.of(page, 4);

		Page<Docente> docentes = docenteService.findAll(pageRequest);

		PageRender<Docente> pageRender = new PageRender<>("/listar", docentes);

		model.addAttribute("primera", paginatorPrimera);
		model.addAttribute("ultima", paginatorUltima);
		model.addAttribute("titulo", tituloListar);
		model.addAttribute("docentes", docentes);
		model.addAttribute("page", pageRender);
		return "admin/listar";
	}

	@GetMapping(value = "/save")
	public String crearDocente(Map<String, Object> model) {

		model.put("titulo", tituloGuardar);
		Docente docente = new Docente();

		model.put("docente", docente);
		return "admin/save";
	}

	@PostMapping("/save")
	public String Guardar(@Valid Docente docente, BindingResult result, Model model,
			@RequestParam("file") MultipartFile foto, RedirectAttributes flash, SessionStatus status) {

		if (result.hasErrors()) {
			model.addAttribute("titulo", tituloGuardar);
			return "admin/save";
		}

		if (!foto.isEmpty()) {

			if (docente.getId() != null && docente.getId() > 0 && docente.getFoto() != null
					&& docente.getFoto().length() > 0 && !docente.getFoto().equals("user.jpg")) {

				uploadFileService.delete(docente.getFoto());

			}

			String uniqueFilename = null;
			try {
				uniqueFilename = uploadFileService.copy(foto);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			flash.addFlashAttribute("info", mensajeFlashCargoFoto);

			docente.setFoto(uniqueFilename);

		} else {
			docente.setFoto("user.jpg");
		}

		model.addAttribute("titulo", tituloListar);
		docenteService.save(docente);
		status.setComplete();
		flash.addFlashAttribute("success", mensajeFlashGuardar);
		return "redirect:listar";

	}

	@RequestMapping(value = "/save/{id}")
	public String editarDocente(@PathVariable(value = "id") Long id, Map<String, Object> model,
			RedirectAttributes flash) {
		Docente docente = null;

		if (id > 0) {
			docente = docenteService.findOne(id);
			if (docente == null) {
				flash.addFlashAttribute("error", mensajeFlashEditarNoEncontrado);
				model.put("titulo", tituloListar);
				return "redirect:/listar";
			}
		} else {
			flash.addFlashAttribute("error", mensajeFlashEditar);
			model.put("titulo", tituloListar);
			return "redirect:/listar";
		}

		model.put("docente", docente);
		model.put("titulo", tituloEditar);

		return "admin/ver";

	}

	@RequestMapping(value = "/eliminar/{id}")
	public String eliminar(@PathVariable(name = "id") Long id, RedirectAttributes flash) {
		if (id > 0) {

			Docente docente = docenteService.findOne(id);

			docenteService.delete(id);
			flash.addFlashAttribute("success", mensajeFlashEliminar);

			if (uploadFileService.delete(docente.getFoto())) {
				flash.addFlashAttribute("info", mensajeFlashFotoEliminada);
			}
		}

		return "redirect:/listar";
	}

	@ModelAttribute("tituloprin")
	public String titulo() {
		return titulo;
	}

	@GetMapping(value = "/ver")
	public String verDocente(Map<String, Object> model) {

		model.put("titulo", tituloGuardar);
		Docente docente = new Docente();

		model.put("docente", docente);
		return "admin/ver";
	}
	
	

}
