package com.julianherrera.springboot.web.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.julianherrera.springboot.web.app.models.entity.Grado;


public interface IGradoService {

public List<Grado> findAll();
	
	public Page<Grado> findAll(Pageable pageable);
	
	public void save(Grado grado);
	
	public Grado findOne(Long id);
	
	public void delete(Long id);
}
