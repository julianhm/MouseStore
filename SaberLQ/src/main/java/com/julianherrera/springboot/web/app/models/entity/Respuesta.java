package com.julianherrera.springboot.web.app.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "respuestas")
public class Respuesta implements Serializable{
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String enunciado;
	
	@NotNull
	private Boolean correcta;
	
	private String UrlImagen;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Pregunta miPregunta;

	

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



	public Boolean getCorrecta() {
		return correcta;
	}



	public void setCorrecta(Boolean correcta) {
		this.correcta = correcta;
	}



	public String getUrlImagen() {
		return UrlImagen;
	}



	public void setUrlImagen(String urlImagen) {
		UrlImagen = urlImagen;
	}



	public Pregunta getMiPregunta() {
		return miPregunta;
	}



	public void setMiPregunta(Pregunta miPregunta) {
		this.miPregunta = miPregunta;
	}



	private static final long serialVersionUID = -6828562489694864963L;
}
