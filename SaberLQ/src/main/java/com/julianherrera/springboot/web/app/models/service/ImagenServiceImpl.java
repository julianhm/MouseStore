package com.julianherrera.springboot.web.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.julianherrera.springboot.web.app.models.dao.IImagenDao;

import com.julianherrera.springboot.web.app.models.entity.Imagen;


@Service
public class ImagenServiceImpl implements IImagenService{

	@Autowired
	private IImagenDao imagenDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Imagen> findAll() {
		
		return (List<Imagen>) imagenDao.findAll();
	}

	@Override
	@Transactional
	public void save(Imagen imagen) {
		imagenDao.save(imagen);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Imagen findOne(Long id) {
		return imagenDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		imagenDao.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Imagen> findAll(Pageable pageable) {
		
		return imagenDao.findAll(pageable);
	}
}
