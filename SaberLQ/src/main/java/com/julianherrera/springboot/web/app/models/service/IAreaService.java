package com.julianherrera.springboot.web.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.julianherrera.springboot.web.app.models.entity.Area;


public interface IAreaService {

	public List<Area> findAll();
	
	public Page<Area> findAll(Pageable pageable);
	
	public void save(Area area);
	
	public Area findOne(Long id);
	
	public void delete(Long id);
}
