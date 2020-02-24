package com.julianherrera.catalogo.web.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.julianherrera.catalogo.web.app.models.entity.ItemPedido;
import com.julianherrera.catalogo.web.app.models.entity.Producto;


public interface IItemPedidoService {

	
	public List<ItemPedido> buscarItemPedido();
	public Page<ItemPedido> buscarItemPedido(Pageable pageable);
	public void crear(ItemPedido itemPedido);
	public ItemPedido buscar(Long id);
	public void eliminar(Long id);
		

}
