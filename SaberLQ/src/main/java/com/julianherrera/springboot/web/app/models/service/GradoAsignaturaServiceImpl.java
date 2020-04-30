package com.julianherrera.springboot.web.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.julianherrera.springboot.web.app.models.dao.IGradoAsignaturaDao;

import com.julianherrera.springboot.web.app.models.entity.GradoAsignatura;

@Service
public class GradoAsignaturaServiceImpl implements IGradoAsignaturaService{

	@Autowired
	private IGradoAsignaturaDao gradoAsignaturaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<GradoAsignatura> findAll() {
		
		return (List<GradoAsignatura>) gradoAsignaturaDao.findAll();
	}

	@Override
	@Transactional
	public void save(GradoAsignatura gradoAsignatura) {
		gradoAsignaturaDao.save(gradoAsignatura);
		
	}

	@Override
	@Transactional(readOnly = true)
	public GradoAsignatura findOne(Long id) {
		return gradoAsignaturaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		gradoAsignaturaDao.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Page<GradoAsignatura> findAll(Pageable pageable) {
		
		return gradoAsignaturaDao.findAll(pageable);
	}
}
