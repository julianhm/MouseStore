package com.julianherrera.catalogo.web.app.models.entity;


import java.io.Serializable;
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

import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "productos")
public class Producto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6004494052161885062L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_producto")
	public Long idProducto;
	
	@NotEmpty
	public String nombre;
	
	
	public String descripcion;
	
	@NotEmpty
	@Column(name="precio_pesos")
	public double precioPesos;
	
	@Column(name="precio_dolar")
	public double precioDolar;
	
	public double peso;
	
	public double largo;
	
	public double ancho;
	
	
	public double profundo;
	
	/**
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(name="categorias_productos", 
	joinColumns = @JoinColumn(name="categoria_id"),
	inverseJoinColumns = @JoinColumn(name="producto_id"))*/
	//public List<Categoria> categorias;
	
	

	
	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioPesos() {
		return precioPesos;
	}

	public void setPrecioPesos(double precioPesos) {
		this.precioPesos = precioPesos;
	}

	public double getPrecioDolar() {
		return precioDolar;
	}

	public void setPrecioDolar(double precioDolar) {
		this.precioDolar = precioDolar;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getLargo() {
		return largo;
	}

	public void setLargo(double largo) {
		this.largo = largo;
	}

	public double getAncho() {
		return ancho;
	}

	public void setAncho(double ancho) {
		this.ancho = ancho;
	}

	public double getProfundo() {
		return profundo;
	}

	public void setProfundo(double profundo) {
		this.profundo = profundo;
	}

	
	
	


/**
	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	
	public void addCategoria(Categoria categoria) {
		categorias.add(categoria);
	}
*/
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	

}
