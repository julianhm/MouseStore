package com.julianherrera.springboot.web.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.julianherrera.springboot.web.app.models.entity.Imagen;



public interface IImagenService {

public List<Imagen> findAll();
	
	public Page<Imagen> findAll(Pageable pageable);
	
	public void save(Imagen imagen);
	
	public Imagen findOne(Long id);
	
	public void delete(Long id);
}
