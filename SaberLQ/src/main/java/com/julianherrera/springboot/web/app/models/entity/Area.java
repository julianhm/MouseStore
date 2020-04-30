package com.julianherrera.springboot.web.app.models.entity;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "areas")
public class Area implements Serializable{


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(name = "nombre")
	private String nombre;
	
	@OneToMany(mappedBy = "area",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Asignatura> misAsignaturas;
	
	
	

	public Area() {
		misAsignaturas= new ArrayList<Asignatura>();
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

	public List<Asignatura> getMisAsignaturas() {
		return misAsignaturas;
	}

	public void setMisAsignaturas(List<Asignatura> misAsignaturas) {
		this.misAsignaturas = misAsignaturas;
	}






	private static final long serialVersionUID = 1L;
	

}
