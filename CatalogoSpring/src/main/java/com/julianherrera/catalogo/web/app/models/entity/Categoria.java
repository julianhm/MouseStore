package com.julianherrera.catalogo.web.app.models.entity;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "categorias")
public class Categoria implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5053293076312367817L;
	
	@NotEmpty
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_categoria")
	public Long idCategoria;
	
	
	@JoinColumn(name="padre")
	@OneToOne(cascade = CascadeType.ALL)
	public Categoria padre;
	
	
	
	@NotEmpty
	public String nombre;
	
	
	
	public String descripcion;
	


	

	public Categoria() { 
		
		//productos= new ArrayList<Producto>();
	}
		


	public Long getIdCategoria() {
		return idCategoria;
	}


	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	



/**
	public List<Producto> getProductos() {
		return productos;
	}


	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	public void addProducto(Producto producto) {
		productos.add(producto);
	}

*/
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	 
}
