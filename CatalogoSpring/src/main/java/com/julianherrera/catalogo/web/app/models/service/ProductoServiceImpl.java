package com.julianherrera.catalogo.web.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.julianherrera.catalogo.web.app.models.dao.IProductoDao;

import com.julianherrera.catalogo.web.app.models.entity.Producto;

@Service 
public class ProductoServiceImpl implements IProductoService{

	@Autowired
	private IProductoDao productoDao;
	
	@Transactional(readOnly=true)
	@Override
	public List<Producto> bucarProducto() {
		// TODO Auto-generated method stub
		return (List<Producto>) productoDao.findAll();
	}

	@Transactional
	@Override
	public void crear(Producto producto) {
		
		productoDao.save(producto);
	}

	@Transactional(readOnly=true)
	@Override
	public Producto buscar(Long id) {
		// TODO Auto-generated method stub
		return productoDao.findById(id).orElse(null);
	}

	@Transactional
	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		productoDao.deleteById(id);
	}

	@Transactional
	@Override
	public Page<Producto> buscarProducto(Pageable pageable) {
		// TODO Auto-generated method stub
		return productoDao.findAll(pageable);
	}

}
