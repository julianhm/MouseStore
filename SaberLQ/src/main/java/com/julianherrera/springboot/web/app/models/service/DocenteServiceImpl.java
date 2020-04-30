package com.julianherrera.springboot.web.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.julianherrera.springboot.web.app.models.dao.IDocenteDao;
import com.julianherrera.springboot.web.app.models.entity.Docente;

@Service
public class DocenteServiceImpl implements IDocenteService {

	@Autowired
	private IDocenteDao docenteDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Docente> findAll() {
		// TODO Auto-generated method stub
		return (List<Docente>) docenteDao.findAll();
	}

	@Override
	@Transactional
	public void save(Docente docente) {
		docenteDao.save(docente);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Docente findOne(Long id) {
		return docenteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		docenteDao.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Docente> findAll(Pageable pageable) {
		
		return docenteDao.findAll(pageable);
	}

}
