package com.julianherrera.springboot.web.app.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "textos")
public class Texto implements Serializable{
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String Titulo;
	
	@NotBlank
	private String contenido;
	
	private String autor;
	
	
	@OneToMany(mappedBy = "miTexto",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Pregunta> misPreguntas;
	
	
	public Texto() {;
		misPreguntas=new ArrayList<Pregunta>();
	}

	
	

	
	public Long getId() {
		return id;
	}





	public void setId(Long id) {
		this.id = id;
	}





	public String getTitulo() {
		return Titulo;
	}





	public void setTitulo(String titulo) {
		Titulo = titulo;
	}





	public String getContenido() {
		return contenido;
	}





	public void setContenido(String contenido) {
		this.contenido = contenido;
	}





	public String getAutor() {
		return autor;
	}





	public void setAutor(String autor) {
		this.autor = autor;
	}





	public List<Pregunta> getMisPreguntas() {
		return misPreguntas;
	}





	public void setMisPreguntas(List<Pregunta> misPreguntas) {
		this.misPreguntas = misPreguntas;
	}





	private static final long serialVersionUID = -7396558495829777884L;
}
