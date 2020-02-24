package com.julianherrera.catalogo.web.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.julianherrera.catalogo.web.app.models.entity.Producto;

public interface IProductoService {
	
	public List<Producto> bucarProducto();
	public Page<Producto> buscarProducto(Pageable pageable);
	public void crear(Producto producto);
	public Producto buscar(Long id);
	public void eliminar(Long id);
	
}
