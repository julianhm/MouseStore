package com.julianherrera.catalogo.web.app.controllers;

import java.util.ArrayList;
import java.util.List;
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
import com.julianherrera.catalogo.web.app.models.service.IPedidoService;
import com.julianherrera.catalogo.web.app.models.service.IProductoService;



@Controller
@SessionAttributes("cliente")
public class ClienteController {
	
	@Autowired
	public IClienteService clienteService;
	
	@Autowired
	public IProductoService productoService;
	
	@Autowired
	public IPedidoService pedidoService;
	
	
	/**
	 * **************************************************************************************
	 * GESTION DE CLIENTES  Y PRODUCTOS DESDE ADMIN
	 * **************************************************************************************
	 */
	
	
	//Metodo que me permito buscar todos los Clientee y enviarlo a la vista cliente
	@RequestMapping(value = "/cliente",method = RequestMethod.GET)
	public String buscarClientes(Model model) {
		
		model.addAttribute("ingresar", "  Ingresar");
		model.addAttribute("titulo", "Cliente");
		model.addAttribute("cliente",clienteService.bucarCliente());
		
		return "cliente";
		
	}
	
	@RequestMapping(value="/eliminarcliente/{id}")
	public String eliminarCliente(@PathVariable(value="id") Long id) {
	
		if(id>0) {
			clienteService.eliminar(id);
		}
		
		return "redirect:/cliente";
	}
	

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
	
	
	//Metodo que recibe de la vista el usuario y la clave y se Busca en la base de datos
		@RequestMapping(value = "/login", method= RequestMethod.POST)
		public String buscarClienteCorreo(Cliente cliente, Model model) {
			
			if(cliente.getCorreo().equals("admin@admin.com")&&cliente.getClave().equals("admin123")) {
				return "redirect:/cliente";
			}
			
			Cliente miCliente= clienteService.buscarPorCorreo(cliente.getCorreo())	;
			
			if(cliente.getCorreo().equals(miCliente.getCorreo()) && cliente.getClave().equals(miCliente.getClave()) ) {
				cliente=miCliente;
				return "redirect:/index/"+cliente.getId();
			}
				return "redirect:/index";
			
				
			
			
		}
		
		/**
		 * ***********************************************************************************
		 * Gestion de Registro de un nuevo cliente
		 * **********************************************************************************
		 */

	//Envio a la pagina de registro, se crea una instancia de cliente y se envia
	@RequestMapping(value="/registro")
	public String crearCliente(Map<String,Object> model) {
		
		Cliente cliente = new Cliente();
		model.put("cliente",cliente);
		model.put("titulo", "Formulario de Cliente");
		model.put("ingresar", "  Ingresar");
		
		return "registroCliente";

	}
	
	//Se recibe el cliente desde la vista y se almacena en base de datos
	@RequestMapping(value="/registro", method = RequestMethod.POST)
	public String GuardarCliente(@Validated Cliente cliente, BindingResult result, Model model, SessionStatus status) {
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Cliente");
			return "registroCliente";
		}
		
		
		clienteService.crear(cliente);
		status.setComplete();
		
		
		return "redirect:index";
		
		
	}
	
	
	/**
	 * ***********************************************************************************
	 * GESTION DE PAGINA DE INICIO
	 * ***********************************************************************************
	 */
	
	
	
	
	//Metodo de la pagina principal
		@RequestMapping({"/index/{id}"})
		public String indexDos(@PathVariable(value="id") Long id, Model model) {
			
			
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
			
			if(id==null) {
				model.addAttribute("ingresar", "  Ingresar");
				model.addAttribute("cantidadCarrito", 0);
			}else {
				
				model.addAttribute("cantidadCarrito", pedidoService.buscarPedidoCliente(id).size() );
				model.addAttribute("ingresar",clienteService.buscar(id).getNombre() );
			}
			
			
			return "index";
			
		}
	
	
	
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
	
	
	/**
	 * **********************************************************************************
	 * GESTION DE CARRITO
	 * *********************************************************************************
	 */
	
	//metodo que envia al usuario a su carrito
	@RequestMapping(value="/cart", method= RequestMethod.GET)
	public String carrito(Model model) {
	
		model.addAttribute("ingresar", "  Ingresar");
		model.addAttribute("cantidadCarrito", 0);
		
		return "carrito";
		
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
