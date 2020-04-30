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


@Entity
@Table(name = "grado_asignatura")
public class GradoAsignatura implements Serializable{
	
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Grado miGrado;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Asignatura miAsignatura;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Docente docente;
	
	@OneToMany(mappedBy = "miGradoASignatura",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Pregunta> misPreguntas;


	
	
	public GradoAsignatura() {
		misPreguntas= new ArrayList<Pregunta>();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Grado getMiGrado() {
		return miGrado;
	}


	public void setMiGrado(Grado miGrado) {
		this.miGrado = miGrado;
	}


	public Asignatura getMiAsignatura() {
		return miAsignatura;
	}


	public void setMiAsignatura(Asignatura miAsignatura) {
		this.miAsignatura = miAsignatura;
	}


	public Docente getDocente() {
		return docente;
	}


	public void setDocente(Docente docente) {
		this.docente = docente;
	}



	public List<Pregunta> getMisPreguntas() {
		return misPreguntas;
	}


	public void setMisPreguntas(List<Pregunta> misPreguntas) {
		this.misPreguntas = misPreguntas;
	}



	private static final long serialVersionUID = 1L;

}
