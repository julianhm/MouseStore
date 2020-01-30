package com.julianherrera.catalogo.web.app.models.dao;



import org.springframework.data.repository.CrudRepository;

import com.julianherrera.catalogo.web.app.models.entity.Categoria;


public interface ICategoriaDao extends CrudRepository<Categoria, Long> {
	
	
	

}
