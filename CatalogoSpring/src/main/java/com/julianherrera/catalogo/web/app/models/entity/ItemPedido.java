package com.julianherrera.catalogo.web.app.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="item_pedidos")
public class ItemPedido implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_item_producto")
	private Long idItemProducto;
	
	
	private Integer cantidad;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_producto")
	private Producto producto;
	
	public Long getIdItemProducto() {
		return idItemProducto;
	}


	public void setIdItemProducto(Long idItemProducto) {
		this.idItemProducto = idItemProducto;
	}


	public Integer getCantidad() {
		return cantidad;
	}


	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double calcularImporte() {
		return cantidad.doubleValue()*producto.getPrecioPesos();
	}

	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	
}
