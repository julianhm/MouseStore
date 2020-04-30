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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "preguntas")
public class Pregunta implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String enunciado;
	
	
	@ManyToOne(fetch=FetchType.LAZY)	
	private GradoAsignatura miGradoASignatura;
	
	
	@OneToMany(mappedBy = "miPregunta",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Respuesta> misRespuestas;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Texto miTexto;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Imagen miImagen;
	
	public Pregunta() {
		misRespuestas=new ArrayList<Respuesta>();
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getEnunciado() {
		return enunciado;
	}



	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}



	public GradoAsignatura getMiGradoASignatura() {
		return miGradoASignatura;
	}



	public void setMiGradoASignatura(GradoAsignatura miGradoASignatura) {
		this.miGradoASignatura = miGradoASignatura;
	}



	public List<Respuesta> getMisRespuestas() {
		return misRespuestas;
	}



	public void setMisRespuestas(List<Respuesta> misRespuestas) {
		this.misRespuestas = misRespuestas;
	}



	public Texto getMiTexto() {
		return miTexto;
	}



	public void setMiTexto(Texto miTexto) {
		this.miTexto = miTexto;
	}



	public Imagen getMiImagen() {
		return miImagen;
	}



	public void setMiImagen(Imagen miImagen) {
		this.miImagen = miImagen;
	}



	private static final long serialVersionUID = 1L;

}
