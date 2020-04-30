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
@Table(name = "imagenes")
public class Imagen implements Serializable{

	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String rutaImagen;
	
	private String descripcion;
	
	@OneToMany(mappedBy = "miImagen",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Pregunta> misPreguntas;
	
	
	public Imagen() {
		misPreguntas=new ArrayList<Pregunta>();
	}

	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getRutaImagen() {
		return rutaImagen;
	}



	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public List<Pregunta> getMisPreguntas() {
		return misPreguntas;
	}



	public void setMisPreguntas(List<Pregunta> misPreguntas) {
		this.misPreguntas = misPreguntas;
	}



	private static final long serialVersionUID = -1796199592170414031L;
}
