package com.julianherrera.springboot.web.app.models.entity;

import javax.validation.constraints.NotEmpty;


public class Login {
	
	@NotEmpty
	private String usuario;
	
	@NotEmpty
	private String clave;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}
	
	

}
