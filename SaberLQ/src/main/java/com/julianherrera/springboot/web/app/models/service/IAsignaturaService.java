package com.julianherrera.springboot.web.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.julianherrera.springboot.web.app.models.entity.Asignatura;


public interface IAsignaturaService {

	public List<Asignatura> findAll();
	
	public Page<Asignatura> findAll(Pageable pageable);
	
	public void save(Asignatura asignatura);
	
	public Asignatura findOne(Long id);
	
	public void delete(Long id);
}
