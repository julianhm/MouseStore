package com.julianherrera.catalogo.web.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.julianherrera.catalogo.web.app.models.dao.IItemPedidoDao;
import com.julianherrera.catalogo.web.app.models.dao.IProductoDao;
import com.julianherrera.catalogo.web.app.models.entity.ItemPedido;


@Service 
public class ItemPedidoServiceImpl implements IItemPedidoService {

	
	@Autowired
	private IItemPedidoDao itemPedidoDao;
	
	
	@Transactional(readOnly=true)
	@Override
	public List<ItemPedido> buscarItemPedido() {
		// TODO Auto-generated method stub
		return (List<ItemPedido>) itemPedidoDao.findAll();
	}

	@Transactional
	@Override
	public void crear(ItemPedido producto) {
		
		itemPedidoDao.save(producto);
	}

	@Transactional(readOnly=true)
	@Override
	public ItemPedido buscar(Long id) {
		// TODO Auto-generated method stub
		return itemPedidoDao.findById(id).orElse(null);
	}

	@Transactional
	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		itemPedidoDao.deleteById(id);
	}

	@Transactional
	@Override
	public Page<ItemPedido> buscarItemPedido(Pageable pageable) {
		// TODO Auto-generated method stub
		return itemPedidoDao.findAll(pageable);
	}



}
