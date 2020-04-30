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
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "grados")
public class Grado implements Serializable {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	private String nivel;
	
	@NotEmpty
	private Integer salon;
	
	@OneToMany(mappedBy = "miGrado",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<GradoAsignatura> misGrados;
	
	
	public Grado() {
		misGrados = new ArrayList<GradoAsignatura>();
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getNivel() {
		return nivel;
	}



	public void setNivel(String nivel) {
		this.nivel = nivel;
	}



	public Integer getSalon() {
		return salon;
	}



	public void setSalon(Integer salon) {
		this.salon = salon;
	}



	public List<GradoAsignatura> getMisGrados() {
		return misGrados;
	}



	public void setMisGrados(List<GradoAsignatura> misGrados) {
		this.misGrados = misGrados;
	}



	private static final long serialVersionUID = 1L;
	
	

}
