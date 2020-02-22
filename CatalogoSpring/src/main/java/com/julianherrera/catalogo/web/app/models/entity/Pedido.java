package com.julianherrera.catalogo.web.app.models.entity;

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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "pedidos")
public class Pedido implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2805550548255165117L;

	@NotEmpty
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido")
	private Long idPedido;

	
	private String observaciones;


	

	@ManyToOne(fetch = FetchType.LAZY)
	private Cliente cliente;
	
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="pedidos_ids")
	private List<ItemPedido> items;
	

	
	
	public Pedido() {
		this.items= new ArrayList<ItemPedido>();
		
	}

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	
	
	public List<ItemPedido> getItems() {
		return items;
	}

	public void setItems(List<ItemPedido> items) {
		this.items = items;
	}
	
	public void addItemsPedido(ItemPedido item) {
		this.items.add(item); 
	}
	
	
	public Double getTotal() {
		Double total=0.0;
		
		int size = items.size();
		
		for(int i=0; i<size; i++) {
			total+= items.get(i).calcularImporte();
		}
		return total;
				
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
