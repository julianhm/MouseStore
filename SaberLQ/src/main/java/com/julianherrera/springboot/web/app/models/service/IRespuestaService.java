package com.julianherrera.springboot.web.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.julianherrera.springboot.web.app.models.entity.Respuesta;


public interface IRespuestaService {

public List<Respuesta> findAll();
	
	public Page<Respuesta> findAll(Pageable pageable);
	
	public void save(Respuesta respuesta);
	
	public Respuesta findOne(Long id);
	
	public void delete(Long id);
}
