package com.julianherrera.springboot.web.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.julianherrera.springboot.web.app.models.entity.GradoAsignatura;


public interface IGradoAsignaturaService {

public List<GradoAsignatura> findAll();
	
	public Page<GradoAsignatura> findAll(Pageable pageable);
	
	public void save(GradoAsignatura gradoAsignatura);
	
	public GradoAsignatura findOne(Long id);
	
	public void delete(Long id);
}
