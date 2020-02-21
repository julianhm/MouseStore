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

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "categorias")
public class Categoria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5053293076312367817L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_categoria")
	public Long idCategoria;

	@ManyToOne
	@JoinColumn(name = "categoria_padre", referencedColumnName = "id_categoria")
	public Categoria categoriaPadre;

	@OneToMany(mappedBy = "categoriaPadre")
	public List<Categoria> categoriasHijo;

	@NotEmpty
	public String nombre;

	public String descripcion;

	public Categoria() {

		 categoriasHijo= new ArrayList<Categoria>();
	}

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	
	public Categoria getCategoriaPadre() {
		return categoriaPadre;
	}

	public void setCategoriaPadre(Categoria categoriaPadre) {
		this.categoriaPadre = categoriaPadre;
	}

	public List<Categoria> getCategoriasHijo() {
		return categoriasHijo;
	}

	public void setCategoriasHijo(List<Categoria> categoriasHijo) {
		this.categoriasHijo = categoriasHijo;
	}
	
	public void addCategoriasHijo(Categoria categoriaHijo) {
		categoriasHijo.add( categoriaHijo) ;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
