package com.julianherrera.springboot.web.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.julianherrera.springboot.web.app.models.entity.Pregunta;


public interface IPreguntaService {

public List<Pregunta> findAll();
	
	public Page<Pregunta> findAll(Pageable pageable);
	
	public void save(Pregunta pregunta);
	
	public Pregunta findOne(Long id);
	
	public void delete(Long id);
}
