package com.ceiba.mercapulgas.dominio;

import java.io.Serializable;

public class ProductosCache implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer idProducto;
	
	
	private String nombreProducto;
	

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
