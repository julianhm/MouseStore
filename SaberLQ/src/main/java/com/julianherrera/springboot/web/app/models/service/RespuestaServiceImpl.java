package com.julianherrera.springboot.web.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.julianherrera.springboot.web.app.models.dao.IRespuestaDao;

import com.julianherrera.springboot.web.app.models.entity.Respuesta;

@Service
public class RespuestaServiceImpl implements IRespuestaService{

	@Autowired
	private IRespuestaDao respuestaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Respuesta> findAll() {
		
		return (List<Respuesta>) respuestaDao.findAll();
	}

	@Override
	@Transactional
	public void save(Respuesta respuesta) {
		respuestaDao.save(respuesta);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Respuesta findOne(Long id) {
		return respuestaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		respuestaDao.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Respuesta> findAll(Pageable pageable) {
		
		return respuestaDao.findAll(pageable);
	}
}
