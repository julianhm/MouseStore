package com.julianherrera.springboot.web.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.julianherrera.springboot.web.app.models.dao.IGradoDao;

import com.julianherrera.springboot.web.app.models.entity.Grado;

@Service
public class GradoServiceImpl implements IGradoService{

	@Autowired
	private IGradoDao gradoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Grado> findAll() {
		
		return (List<Grado>) gradoDao.findAll();
	}

	@Override
	@Transactional
	public void save(Grado asignatura) {
		gradoDao.save(asignatura);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Grado findOne(Long id) {
		return gradoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		gradoDao.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Grado> findAll(Pageable pageable) {
		
		return gradoDao.findAll(pageable);
	}
}
