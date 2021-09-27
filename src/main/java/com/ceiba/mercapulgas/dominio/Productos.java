package com.ceiba.mercapulgas.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "productos")
public class Productos implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id()
	@Column(name = "idproducto")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProducto;
	
	@Column(name = "nombreproducto")
	private String nombreProducto;
	
	@Column (name = "precioproducto")
	private Integer precioProducto;


	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public Integer getPrecioProducto() {
		return precioProducto;
	}

	public void setPrecioProducto(Integer precioProducto) {
		this.precioProducto = precioProducto;
	}
	
	
	
	
	

}
