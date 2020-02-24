package com.julianherrera.catalogo.web.app.models.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.julianherrera.catalogo.web.app.models.entity.Cliente;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ClienteServiceImplTest {
	
	@Autowired
	public IClienteService clienteService;

	

	@Test
	public void testCrear() {
		//clienteService.eliminatTodo();
		
		Cliente unCliente = new Cliente();
		unCliente.setCelular("12345");
		unCliente.setCodPostal("12");
		unCliente.setCorreo("test@test.com");
		unCliente.setDireccion("ejemplito");
		unCliente.setEstado("Quindio");
		unCliente.setFoto("foto.jpg");
		unCliente.setNombre("pedro");
		unCliente.setPais("Zarflag");
		unCliente.setTelefono("987654321");
		
		clienteService.crear(unCliente);
		
		String expected = "test@test.com";
		
		Cliente miCliente= clienteService.buscarPorCorreo("test@test.com");
		
		assertEquals(expected, miCliente.getCorreo());
		
		//clienteService.eliminar(miCliente.getId());
	}

	
	
	@Test
	public void testBuscarPorCorreo() {
		
		Cliente unCliente = new Cliente();
		unCliente.setCelular("12345");
		unCliente.setCodPostal("12");
		unCliente.setCorreo("test@test.com");
		unCliente.setDireccion("ejemplito");
		unCliente.setEstado("Quindio");
		unCliente.setFoto("foto.jpg");
		unCliente.setNombre("pedro");
		unCliente.setPais("Zarflag");
		unCliente.setTelefono("987654321");
		unCliente.setId((long) 123);
		
		clienteService.crear(unCliente);
		
		String email = "test@test.com";
		
		String expected = "test@test.com";
		
		Cliente miCliente= clienteService.buscarPorCorreo(email);
		
		assertEquals(expected, miCliente.getCorreo());
		//clienteService.eliminar(miCliente.getId());
	}

	
	
	@Test
	public void testBucarCliente() {
		//clienteService.eliminatTodo();
		
		for (int i = 0; i < 3; i++) {
			Cliente unCliente = new Cliente();
			unCliente.setCelular("12345");
			unCliente.setCodPostal("12");
			unCliente.setCorreo("test@test.com");
			unCliente.setDireccion("ejemplito");
			unCliente.setEstado("Quindio");
			unCliente.setFoto("foto.jpg");
			unCliente.setNombre("pedro");
			unCliente.setPais("Zarflag");
			unCliente.setTelefono("987654321");
			
			clienteService.crear(unCliente);
		}
		
		assertTrue(clienteService.bucarCliente().size() >= 3);
			
		//clienteService.eliminatTodo();
	}
	
	
	@Test
	public void testBuscar() {
		
		Cliente unCliente = new Cliente();
		unCliente.setCelular("12345");
		unCliente.setCodPostal("12");
		unCliente.setCorreo("test@test.com");
		unCliente.setDireccion("ejemplito");
		unCliente.setEstado("Quindio");
		unCliente.setFoto("foto.jpg");
		unCliente.setNombre("pedro");
		unCliente.setPais("Zarflag");
		unCliente.setTelefono("987654321");
		unCliente.setId((long) 1);
		
		clienteService.crear(unCliente);
		
		//Long id = (long) 123;
		
		Cliente miCliente= clienteService.buscar((long) 1);
		System.out.println("existe "+miCliente.getId());
		
		assertTrue((long) 1 == miCliente.getId());
		
		//clienteService.eliminar(miCliente.getId());
	}
	
	
	@Test
	public void testEliminar() {
		//clienteService.eliminatTodo();
		
		Cliente unCliente = new Cliente();
		unCliente.setCelular("12345");
		unCliente.setCodPostal("12");
		unCliente.setCorreo("test@test.com");
		unCliente.setDireccion("ejemplito");
		unCliente.setEstado("Quindio");
		unCliente.setFoto("foto.jpg");
		unCliente.setNombre("pedro");
		unCliente.setPais("Zarflag");
		unCliente.setTelefono("987654321");
		unCliente.setId((long) 123);
		
		clienteService.crear(unCliente);
		
		Long id = (long) 123;
		
		clienteService.eliminar(id);
		if (clienteService.buscar(id)== null) {
			//clienteService.eliminar(unCliente.getId());
			assertTrue(true);
		}else {
			//clienteService.eliminar(unCliente.getId());
			assertTrue(false);
		}
		
					
	}
	

}