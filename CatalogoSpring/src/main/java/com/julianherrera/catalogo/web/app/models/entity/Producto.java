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
import javax.validation.constraints.NotNull;


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
	
	@NotNull
	@Column(name="precio_pesos")
	public Double precioPesos;
	
	@Column(name="precio_dolar")
	public Double precioDolar;
	
	public Double peso;
	
	public Double largo;
	
	public Double ancho;
	
	
	public Double profundo;
	
	private String Foto;
	
	/**
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(name="categorias_productos", 
	joinColumns = @JoinColumn(name="categoria_id"),
	inverseJoinColumns = @JoinColumn(name="producto_id"))*/
	//public List<Categoria> categorias;
	
	

	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

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



	public Double getPrecioPesos() {
		return precioPesos;
	}

	public void setPrecioPesos(Double precioPesos) {
		this.precioPesos = precioPesos;
	}

	public Double getPrecioDolar() {
		return precioDolar;
	}

	public void setPrecioDolar(Double precioDolar) {
		this.precioDolar = precioDolar;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getLargo() {
		return largo;
	}

	public void setLargo(Double largo) {
		this.largo = largo;
	}

	public Double getAncho() {
		return ancho;
	}

	public void setAncho(Double ancho) {
		this.ancho = ancho;
	}

	public Double getProfundo() {
		return profundo;
	}

	public void setProfundo(Double profundo) {
		this.profundo = profundo;
	}

	public String getFoto() {
		return Foto;
	}

	public void setFoto(String foto) {
		Foto = foto;
	}
	
	
	
	

}
