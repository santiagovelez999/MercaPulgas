package com.ceiba.mercapulgas.service;


import org.springframework.data.domain.Page;

import com.ceiba.mercapulgas.dominio.Productos;

public interface ProductosService {

	public Page<Productos> getProductos(int page, int size);
	public Page<Productos> search(int page, int size, String search);
}
