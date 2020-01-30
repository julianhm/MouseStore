package com.julianherrera.catalogo.web.app.models.entity;



import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "categoria")
public class Categoria implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5053293076312367817L;
	
	@NotEmpty
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long idCategoria;
	
	@NotEmpty
	public int nivel;
	
	@NotEmpty
	public String nombre;
	
	
	public Long categPadre;
	
	@Lob
	public byte[] fotoCateg;



	public Long getIdCategoria() {
		return idCategoria;
	}


	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}


	public int getNivel() {
		return nivel;
	}


	public void setNivel(int nivel) {
		this.nivel = nivel;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Long getCategPadre() {
		return categPadre;
	}


	public void setCategPadre(Long categPadre) {
		this.categPadre = categPadre;
	}



	public byte[] getFotoCateg() {
		return fotoCateg;
	}

	public void setFotoCateg(byte[] fotoCateg) {
		this.fotoCateg = fotoCateg;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	 
}
