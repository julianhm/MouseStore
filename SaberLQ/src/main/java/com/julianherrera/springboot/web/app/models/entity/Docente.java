package com.julianherrera.springboot.web.app.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name = "docentes")
public class Docente implements Serializable{

	@Id
	@NotNull
	private Long id;
	

	
	@NotBlank
	private String nombre;
	
	
	@NotBlank
	private String apellido;
	

	@NotBlank
	@Email
	private String email;

	
	@Column(name = "telefono_cel")
	@NotBlank
	private String telefonoCel;

	
	@Column(name = "telefono_fijo")
	private String telefonoFijo;

	@Column(name = "fecha_nacimiento")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Past
	@NotNull
	private Date fechaNacimiento;
	
	
	private String foto;
	
	
	@OneToMany(mappedBy = "docente",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<GradoAsignatura> misGrados;

	
	
	
	public Docente() {
		misGrados=new ArrayList<GradoAsignatura>();
	}

	
	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefonoCel() {
		return telefonoCel;
	}

	public void setTelefonoCel(String telefonoCel) {
		this.telefonoCel = telefonoCel;
	}

	public String getTelefonoFijo() {
		return telefonoFijo;
	}

	public void setTelefonoFijo(String telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public List<GradoAsignatura> getMisGrados() {
		return misGrados;
	}


	public void setMisGrados(List<GradoAsignatura> misGrados) {
		this.misGrados = misGrados;
	}





	private static final long serialVersionUID = 1L;

}
