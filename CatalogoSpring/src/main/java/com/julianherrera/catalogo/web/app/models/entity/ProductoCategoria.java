package com.julianherrera.catalogo.web.app.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import net.bytebuddy.dynamic.TypeResolutionStrategy.Lazy;

@Entity
@Table(name= "productos_categorias")
public class ProductoCategoria implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7846640308179543142L;

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long idProductosCategorias;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Producto producto;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Categoria categoria;

	public Long getIdProductosCategorias() {
		return idProductosCategorias;
	}

	public void setIdProductosCategorias(Long idProductosCategorias) {
		this.idProductosCategorias = idProductosCategorias;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
	
	

}
