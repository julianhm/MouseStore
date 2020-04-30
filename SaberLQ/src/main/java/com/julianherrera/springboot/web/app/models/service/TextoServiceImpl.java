package com.julianherrera.springboot.web.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.julianherrera.springboot.web.app.models.dao.ITextoDao;

import com.julianherrera.springboot.web.app.models.entity.Texto;

@Service
public class TextoServiceImpl implements ITextoService{

	@Autowired
	private ITextoDao textoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Texto> findAll() {
		
		return (List<Texto>) textoDao.findAll();
	}

	@Override
	@Transactional
	public void save(Texto texto) {
		textoDao.save(texto);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Texto findOne(Long id) {
		return textoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		textoDao.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Texto> findAll(Pageable pageable) {
		
		return textoDao.findAll(pageable);
	}
}
