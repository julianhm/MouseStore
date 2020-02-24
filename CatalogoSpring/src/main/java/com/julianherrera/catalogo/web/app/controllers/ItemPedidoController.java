package com.julianherrera.catalogo.web.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.julianherrera.catalogo.web.app.models.entity.Cliente;
import com.julianherrera.catalogo.web.app.models.entity.ItemPedido;
import com.julianherrera.catalogo.web.app.models.entity.Pedido;
import com.julianherrera.catalogo.web.app.models.entity.Producto;
import com.julianherrera.catalogo.web.app.models.service.IClienteService;
import com.julianherrera.catalogo.web.app.models.service.IItemPedidoService;
import com.julianherrera.catalogo.web.app.models.service.IPedidoService;
import com.julianherrera.catalogo.web.app.models.service.IProductoService;


@Controller
@RequestMapping("/itempedido")
public class ItemPedidoController {
	
	@Autowired
	public IItemPedidoService itemPedidoService;
	
	@Autowired
	public IProductoService productoService;
	
	@Autowired
	public IClienteService clienteService;
	
	@Autowired
	public IPedidoService pedidoService;
	
	
	@RequestMapping(value="/item/{id}/{idproducto}",method= RequestMethod.GET)
	public String crearPedido(@Validated Pedido pedido,@PathVariable(value="id") Long id, @PathVariable(value="idproducto") Long idProducto,Model model,RedirectAttributes flash) {
		
		Producto producto = productoService.buscar(idProducto);
		Cliente cliente= clienteService.buscar(id);
		
		
		ItemPedido itemPedido= new ItemPedido();
		
		itemPedido.setProducto(producto);
		itemPedido.setCantidad(1);
		
		itemPedidoService.crear(itemPedido);
		
	int indicePedidoActivo=-1;
		
		if(cliente.getPedidos().size()!=0) {
			for(int i=0;i<cliente.getPedidos().size();i++) {
				if(cliente.getPedidos().get(i).getActivo()) {
					indicePedidoActivo=i;
					break;
				}
			}
			
		}
		
	
		if(indicePedidoActivo!=-1) {
			
			cliente.getPedidos().get(indicePedidoActivo).addItemsPedido(itemPedido);
			clienteService.crear(cliente);
			//pedidoService.crear(cliente.getPedidos().get(indicePedidoActivo));
			
		}else {
			
			
			
			pedido.addItemsPedido(itemPedido);
			pedidoService.crear(pedido);
			
			cliente.addPedido(pedido);
			pedido.setCliente(cliente);
			
			clienteService.crear(cliente);
		}
		
		flash.addAttribute("info", "Su pedido se realizo con exito");
	
				
		return "redirect:/producto/store";

	}
	

}
