package com.julianherrera.catalogo.web.app.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.julianherrera.catalogo.web.app.models.entity.Cliente;
import com.julianherrera.catalogo.web.app.models.entity.Producto;
import com.julianherrera.catalogo.web.app.models.service.ICategoriaService;
import com.julianherrera.catalogo.web.app.models.service.IClienteService;
import com.julianherrera.catalogo.web.app.models.service.IProductoService;
import com.julianherrera.catalogo.web.app.util.paginator.PageRender;

@Controller
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	public IProductoService productoService;
	
	@Autowired
	public ICategoriaService categoriaService;
	
	
	/**
	 * **************************************************************************************
	 * GESTION PRODUCTOS DESDE ADMIN
	 * **************************************************************************************
	 */
	
	
	
	//Metodo que permite ir a la pagina para crear un nuevo producto
	@RequestMapping(value="/form")
	public String crearProducto(Model model) {
		
		Producto producto = new Producto();
		model.addAttribute("producto",producto);
		model.addAttribute("titulo", "Formulario de Productos");

		model.addAttribute("cantidadCarrito", 0);
		model.addAttribute("ingresar", "  Administrador");
		
		model.addAttribute("todasCategorias", categoriaService.bucarCategoria());
		
		
		return "producto/gestionProductos";

	}
	
	//Este metodo recibe el producto creado en la vista y lo envia a la base de datos
		@RequestMapping(value="/form", method = RequestMethod.POST)
		public String GuardarProducto(@Validated Producto producto, BindingResult result,
				Model model, @RequestParam("file") MultipartFile foto, 
				RedirectAttributes flash, SessionStatus status) {
			
			if(result.hasErrors()) {
				
				
				model.addAttribute("titulo", "Formulario de Productos");
				
				model.addAttribute("cantidadCarrito", 0);
				
				model.addAttribute("ingresar", "  Administrador");
				model.addAttribute("todasCategorias", categoriaService.bucarCategoria());
				
				return "producto/gestionProductos";
			}
			
			if(!foto.isEmpty()) {
				 Path directorioRecursos = Paths.get("src//main//resources//static/uploads");
				 String rootPath = directorioRecursos.toFile().getAbsolutePath();
				 try {
					byte[] bytes = foto.getBytes();
					Path rutaCompleta = Paths.get(rootPath + "//" + foto.getOriginalFilename());
					Files.write(rutaCompleta, bytes);
					flash.addFlashAttribute("info", "Has subido correctamente la imagen '" + foto.getOriginalFilename()+"'");
					
					producto.setFoto(foto.getOriginalFilename());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			productoService.crear(producto);
			status.setComplete();
			flash.addFlashAttribute("info", "El producto se creo correctamente");
			
			return "redirect:/producto/form";
			
			
		}
		
		//Este método recibe el ID por url y lo envia a la pagina editar
		@RequestMapping(value="/editarproductos/{id}")
		public String editarProducto(@PathVariable(value="id") Long id, Map<String,Object> model) {
			
			Producto producto = null;
			
			if(id>0) {
				producto = productoService.buscar(id);
			}else {
				return "redirect:/gestionProductos";
			}
			
			model.put("producto", producto);
			model.put("titulo", "Editar Producto");
			
			return "redirect:/producto/form";
		}
		
		
		
		//	//Este método recibe el ID por url y lo envia a la pagina eliminar
		@RequestMapping(value="/eliminarproducto/{id}")
		public String eliminarProducto(@PathVariable(value="id") Long id) {
		
			if(id>0) {
				productoService.eliminar(id);
			}
			
			return "redirect:/producto/form";
		}

	
	
	
	//metodo que retorna una lista de productos
		@RequestMapping(value = "/listarProductos",method = RequestMethod.GET)
		public String buscarProducto(@RequestParam(name="page", defaultValue = "0") int page, Model model) {
			
			Pageable pageRequest = PageRequest.of(page, 12);
			
			Page<Producto> productos= productoService.buscarProducto(pageRequest);
			PageRender<Producto> pageRender=new PageRender<>("/listarProductos", productos);
			model.addAttribute("cantidadCarrito", 0);
			model.addAttribute("titulo", "CATALOGO");
			model.addAttribute("ingresar", "  Ingresar");
			model.addAttribute("producto",productos);
			model.addAttribute("page",pageRender);
			
			return "redirect:/producto/form";
			
		}
	
	
	
	/**
	 * **********************************************************************************
	 * GESTION PAGINA CATALOGO
	 * *********************************************************************************
	 */
	
	//metodo que envia al usuario al catalogo de la tienda
	@RequestMapping(value="/store", method= RequestMethod.GET)
	public String catalogo(@RequestParam(name="page", defaultValue = "0") int page,Model model) {
		
		Pageable pageRequest = PageRequest.of(page, 12);
		
		Page<Producto> productos= productoService.buscarProducto(pageRequest);
		PageRender<Producto> pageRender=new PageRender<>("/listarProductos", productos);
		model.addAttribute("cantidadCarrito", 0);
		model.addAttribute("titulo", "CATALOGO");
		model.addAttribute("ingresar", "  Ingresar");
		model.addAttribute("producto",productos);
		model.addAttribute("page",pageRender);
		
		
		return "producto/store";
		
	}
	
	
	
	

}
