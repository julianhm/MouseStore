package com.julianherrera.catalogo.web.app.models.dao;


import org.springframework.data.repository.CrudRepository;


import com.julianherrera.catalogo.web.app.models.entity.Producto;

public interface IProductoDao extends CrudRepository<Producto, Long> {
	
	
	

}
