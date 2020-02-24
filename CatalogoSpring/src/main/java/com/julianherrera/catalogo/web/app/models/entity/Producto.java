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
import javax.persistence.OneToMany;
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
	private Long idProducto;
	
	@NotEmpty
	private String nombre;
	
	
	private String descripcion;
	
	
	@Column(name="precio_pesos")
	private Double precioPesos;
	
	@Column(name="precio_dolar")
	private Double precioDolar;
	
	private Double peso;
	
	private Double largo;
	
	private Double ancho;
	
	
	private Double profundo;
	
	private String Foto;
	
	private String Foto2;
	
	private String Foto3;
	

	
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

	public String getFoto2() {
		return Foto2;
	}

	public void setFoto2(String foto2) {
		Foto2 = foto2;
	}

	public String getFoto3() {
		return Foto3;
	}

	public void setFoto3(String foto3) {
		Foto3 = foto3;
	}
	
	
	

}
