package com.julianherrera.catalogo.web.app.models.dao;



import org.springframework.data.repository.PagingAndSortingRepository;

import com.julianherrera.catalogo.web.app.models.entity.Producto;

public interface IProductoDao extends PagingAndSortingRepository<Producto, Long> {
	
	
	

}
