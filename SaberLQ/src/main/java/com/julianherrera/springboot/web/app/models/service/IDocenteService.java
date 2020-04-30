package com.julianherrera.springboot.web.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.julianherrera.springboot.web.app.models.entity.Docente;

public interface IDocenteService {
	
	public List<Docente> findAll();
	
	public Page<Docente> findAll(Pageable pageable);
	
	public void save(Docente docente);
	
	public Docente findOne(Long id);
	
	public void delete(Long id);
}
