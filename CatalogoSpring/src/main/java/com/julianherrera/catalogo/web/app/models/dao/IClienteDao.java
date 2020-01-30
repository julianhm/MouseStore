package com.julianherrera.catalogo.web.app.models.dao;


import org.springframework.data.repository.CrudRepository;

import com.julianherrera.catalogo.web.app.models.entity.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Long>{
	
	
	

}
