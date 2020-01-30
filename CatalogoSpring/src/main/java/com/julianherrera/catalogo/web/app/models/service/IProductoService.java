package com.julianherrera.catalogo.web.app.models.service;

import java.util.List;


import com.julianherrera.catalogo.web.app.models.entity.Producto;

public interface IProductoService {
	public List<Producto> bucarProducto();
	public void crear(Producto producto);
	public Producto buscar(Long id);
	public void eliminar(Long id);
	
}
