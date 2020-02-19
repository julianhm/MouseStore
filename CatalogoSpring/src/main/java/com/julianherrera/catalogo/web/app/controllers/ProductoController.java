package com.julianherrera.catalogo.web.app.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.julianherrera.catalogo.web.app.models.entity.Cliente;
import com.julianherrera.catalogo.web.app.models.entity.Producto;
import com.julianherrera.catalogo.web.app.models.service.IClienteService;
import com.julianherrera.catalogo.web.app.models.service.IProductoService;

@Controller
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	public IProductoService productoService;
	
	
	
	
	/**
	 * **************************************************************************************
	 * GESTION PRODUCTOS DESDE ADMIN
	 * **************************************************************************************
	 */
	
	
	
	//Metodo que permite ir a la pagina para crear un nuevo producto
	@RequestMapping(value="/product")
	public String crearProducto(Model model) {
		
		Producto producto = new Producto();
		model.addAttribute("producto",producto);
		model.addAttribute("titulo", "Formulario de Productos");

		model.addAttribute("cantidadCarrito", 0);
		model.addAttribute("tituloPrin", "Productos");
		model.addAttribute("ingresar", "  Administrador");
		
		
		return "gestionProductos";

	}
	
	//Este metodo recibe el producto creado en la vista y lo envia a la base de datos
		@RequestMapping(value="/product", method = RequestMethod.POST)
		public String GuardarProducto(@Validated Producto producto, BindingResult result, Model model, SessionStatus status) {
			if(result.hasErrors()) {
				productoService.crear(producto);
				model.addAttribute("titulo", "Formulario de Productos");
				
				model.addAttribute("cantidadCarrito", 0);
				model.addAttribute("tituloPrin", "Productos");
				model.addAttribute("ingresar", "  Administrador");
				
				return "gestionProductos";
			}
			
			
			productoService.crear(producto);
			status.setComplete();
			
			
			return "redirect:/gestionProductos";
			
			
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
			
			return "gestionProductos";
		}
		
		
		
		//	//Este método recibe el ID por url y lo envia a la pagina eliminar
		@RequestMapping(value="/eliminarproducto/{id}")
		public String eliminarProducto(@PathVariable(value="id") Long id) {
		
			if(id>0) {
				productoService.eliminar(id);
			}
			
			return "redirect:/gestionProductos";
		}

	
	
	
	//metodo que retorna una lista de productos
		@RequestMapping(value = "/listarProductos",method = RequestMethod.GET)
		public String buscarProducto(Model model) {
			
			model.addAttribute("tituloprinc", "MOUSE STORE");
			model.addAttribute("cantidadCarrito", 0);
			model.addAttribute("titulo", "Cliente");
			model.addAttribute("ingresar", "  Ingresar");
			model.addAttribute("producto",productoService.bucarProducto());
			
			return "gestionProductos";
			
		}
	
	
	
	/**
	 * **********************************************************************************
	 * GESTION PAGINA CATALOGO
	 * *********************************************************************************
	 */
	
	//metodo que envia al usuario al catalogo de la tienda
	@RequestMapping(value="/store", method= RequestMethod.GET)
	public String catalogo(Model model) {
		
		model.addAttribute("cantidadCarrito", 0);
		model.addAttribute("ingresar", "Ingresar");
		model.addAttribute("productos",productoService.bucarProducto());
		
		
		return "store";
		
	}
	
	
	
	

}
