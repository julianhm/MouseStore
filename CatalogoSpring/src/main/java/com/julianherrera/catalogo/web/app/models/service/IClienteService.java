package com.julianherrera.catalogo.web.app.models.service;

import java.util.List;

import com.julianherrera.catalogo.web.app.models.entity.Cliente;

public interface IClienteService {
	public List<Cliente> bucarCliente();
	public void crear(Cliente cliente);
	public Cliente buscar(Long id);
	public void eliminar(Long id);
	
}
