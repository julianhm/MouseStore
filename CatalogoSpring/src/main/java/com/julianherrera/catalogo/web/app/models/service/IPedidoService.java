package com.julianherrera.catalogo.web.app.models.service;

import java.util.List;


import com.julianherrera.catalogo.web.app.models.entity.Pedido;

public interface IPedidoService {
	public List<Pedido> buscarPedidoCliente(Long idCliente);
	public void crear(Pedido pedido);
	public Pedido buscar(Long id);
	public void eliminar(Long id);

	
}
