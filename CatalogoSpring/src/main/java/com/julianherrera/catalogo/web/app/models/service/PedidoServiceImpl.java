package com.julianherrera.catalogo.web.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.julianherrera.catalogo.web.app.models.dao.IPedidoDao;

import com.julianherrera.catalogo.web.app.models.entity.Pedido;

@Service 
public class PedidoServiceImpl implements IPedidoService{

	@Autowired
	private IPedidoDao pedidoDao;
	
	@Transactional(readOnly=true)
	@Override
	public List<Pedido> bucarPedido() {
		// TODO Auto-generated method stub
		return (List<Pedido>) pedidoDao.findAll();
	}

	@Transactional
	@Override
	public void crear(Pedido cliente) {
		
		pedidoDao.save(cliente);
	}

	@Transactional(readOnly=true)
	@Override
	public Pedido buscar(Long id) {
		// TODO Auto-generated method stub
		return pedidoDao.findById(id).orElse(null);
	}

	@Transactional
	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		pedidoDao.deleteById(id);
	}

}
