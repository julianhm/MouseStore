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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "pedidos")
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
	public int cantidad;
	
	public String direccion;
	
	public double costo;
	
	
	
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	public Cliente cliente;
	
	/**
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(name="pedidos_productos", 
	joinColumns = @JoinColumn(name="pedido_id"),
	inverseJoinColumns = @JoinColumn(name="producto_id"))*/
	//public List<Producto> productos;


	public Pedido() {
		//productos = new ArrayList<Producto>();
	}

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	
	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	

	
/**
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**public List<Producto> getProdutos() {
		return productos;
	}

	public void setProdutos(List<Producto> produtos) {
		this.productos = produtos;
	}
	
	public void addProducto(Producto producto) {
		productos.add(producto);
	}
*/
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
	

	

}
