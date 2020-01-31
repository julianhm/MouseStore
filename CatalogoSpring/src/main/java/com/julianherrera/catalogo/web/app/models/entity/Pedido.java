package com.julianherrera.catalogo.web.app.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "pedido")
public class Pedido implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2805550548255165117L;

	@NotEmpty
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_pedido")
	public Long idPedido;
	
	@NotEmpty
	@Column(name="mi_producto")
	public Long miProducto;
	
	@NotEmpty
	public int cantidad;
	
	@NotEmpty
	@Column(name="id_cliente")
	public Long idCliente;
	
	



	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public Long getMiProducto() {
		return miProducto;
	}

	public void setMiProducto(Long miProducto) {
		this.miProducto = miProducto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
	

	

}
