package com.julianherrera.catalogo.web.app.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.web.context.annotation.SessionScope;



@Entity
@Table(name = "clientes")
@SessionScope
public class Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@NotEmpty
	private String nombre;
	
	@NotEmpty
	@Size(min=8)
	private String clave;
	
	@NotEmpty
	@Email
	private String correo;
	
	@NotEmpty
	private String direccion;
	
	
	@NotEmpty
	@Column(name="codigo_postal")
	private String codPostal;
	
	private String telefono;
	
	@NotEmpty
	private String celular;
	
	
	@OneToMany(mappedBy = "cliente",fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Pedido> pedidos;
	
	
	

	public Cliente() {
		pedidos= new ArrayList<Pedido>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long correo) {
		this.id = correo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	
	
	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCodPostal() {
		return codPostal;
	}

	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

/**
	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	public void addPedido(Pedido pedido) {
		pedidos.add(pedido);
	}
*/
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
