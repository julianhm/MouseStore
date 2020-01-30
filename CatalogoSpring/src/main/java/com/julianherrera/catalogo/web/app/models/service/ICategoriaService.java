package com.julianherrera.catalogo.web.app.models.service;

import java.util.List;

import com.julianherrera.catalogo.web.app.models.entity.Categoria;


public interface ICategoriaService {
	public List<Categoria> bucarCategoria();
	public void crear(Categoria categoria);
	public Categoria buscar(Long id);
	public void eliminar(Long id);
	
}
