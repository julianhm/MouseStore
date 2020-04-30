package com.julianherrera.springboot.web.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.julianherrera.springboot.web.app.models.entity.Texto;


public interface ITextoService {

public List<Texto> findAll();
	
	public Page<Texto> findAll(Pageable pageable);
	
	public void save(Texto texto);
	
	public Texto findOne(Long id);
	
	public void delete(Long id);
}
