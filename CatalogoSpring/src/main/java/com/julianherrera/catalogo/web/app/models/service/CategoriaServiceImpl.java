package com.julianherrera.catalogo.web.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.julianherrera.catalogo.web.app.models.dao.ICategoriaDao;

import com.julianherrera.catalogo.web.app.models.entity.Categoria;


@Service 
public class CategoriaServiceImpl implements ICategoriaService{

	@Autowired
	private ICategoriaDao categoriaDao;
	
	@Transactional(readOnly=true)
	@Override
	public List<Categoria> bucarCategoria() {
		// TODO Auto-generated method stub
		return (List<Categoria>) categoriaDao.findAll();
	}

	@Transactional
	@Override
	public void crear(Categoria categoria) {
		
		categoriaDao.save(categoria);
	}

	@Transactional(readOnly=true)
	@Override
	public Categoria buscar(Long id) {
		// TODO Auto-generated method stub
		return categoriaDao.findById(id).orElse(null);
	}

	@Transactional
	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		categoriaDao.deleteById(id);
	}

}
