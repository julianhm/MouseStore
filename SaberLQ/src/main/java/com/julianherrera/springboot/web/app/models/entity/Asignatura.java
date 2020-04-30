package com.julianherrera.springboot.web.app.models.entity;



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
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "asignaturas")
public class Asignatura {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String nombre;
	
	@NotNull
	@ManyToOne(fetch=FetchType.LAZY)
	private Area area;
	
	@OneToMany(mappedBy = "miAsignatura",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<GradoAsignatura> misGrados;

	
	
	
	
	public Asignatura() {
		misGrados = new ArrayList<GradoAsignatura>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public List<GradoAsignatura> getMisGrados() {
		return misGrados;
	}

	public void setMisGrados(List<GradoAsignatura> misGrados) {
		this.misGrados = misGrados;
	}
	
	

}
