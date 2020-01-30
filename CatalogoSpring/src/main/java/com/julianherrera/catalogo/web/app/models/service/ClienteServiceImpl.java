package com.julianherrera.catalogo.web.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.julianherrera.catalogo.web.app.models.dao.IClienteDao;
import com.julianherrera.catalogo.web.app.models.entity.Cliente;

@Service 
public class ClienteServiceImpl implements IClienteService{

	@Autowired
	private IClienteDao clienteDao;
	
	@Transactional(readOnly=true)
	@Override
	public List<Cliente> bucarCliente() {
		// TODO Auto-generated method stub
		return (List<Cliente>) clienteDao.findAll();
	}

	@Transactional
	@Override
	public void crear(Cliente cliente) {
		
		clienteDao.save(cliente);
	}

	@Transactional(readOnly=true)
	@Override
	public Cliente buscar(Long id) {
		// TODO Auto-generated method stub
		return clienteDao.findById(id).orElse(null);
	}

	@Transactional
	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		clienteDao.deleteById(id);
	}

}
