package com.julianherrera.springboot.web.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.julianherrera.springboot.web.app.models.dao.IAsignaturaDao;

import com.julianherrera.springboot.web.app.models.entity.Asignatura;

@Service
public class AsignaturaServiceImpl implements IAsignaturaService{

	@Autowired
	private IAsignaturaDao asignaturaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Asignatura> findAll() {
		
		return (List<Asignatura>) asignaturaDao.findAll();
	}

	@Override
	@Transactional
	public void save(Asignatura asignatura) {
		asignaturaDao.save(asignatura);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Asignatura findOne(Long id) {
		return asignaturaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		asignaturaDao.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Asignatura> findAll(Pageable pageable) {
		
		return asignaturaDao.findAll(pageable);
	}
}
