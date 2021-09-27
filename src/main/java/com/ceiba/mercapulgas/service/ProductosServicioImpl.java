package com.ceiba.mercapulgas.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ceiba.mercapulgas.dao.ProductosDao;
import com.ceiba.mercapulgas.dominio.Productos;

@Service
public class ProductosServicioImpl implements ProductosService{

	
	@Autowired
	ProductosDao productosDao;
	
	
	
	@Override
	public Page<Productos> getProductos(int page, int size) {
		return productosDao.findAll(PageRequest.of(page, size));
	}



	@Override
	public Page<Productos> search(int page, int size, String search) {
		return productosDao.findByNombreProducto(PageRequest.of(page, size), search);
		
	}

}
