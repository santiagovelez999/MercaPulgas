package com.ceiba.mercapulgas.service;





import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ceiba.mercapulgas.cache.Cache;
import com.ceiba.mercapulgas.dao.ProductosDao;
import com.ceiba.mercapulgas.dominio.Productos;
import com.ceiba.mercapulgas.dominio.ProductosCache;


@Service
public class ProductosServicioImpl implements ProductosService{

	
	@Autowired
	ProductosDao productosDao;
	
	@Autowired
	private Cache cache;
	
	
	
	@Override
	public Page<Productos> getProductos(int page, int size) {
		return productosDao.findAll(PageRequest.of(page, size));
	}

	
	@Override
	public Page<Productos> search(int page, int size, String search) {
		cache.setKey(search);
		Page<Productos> cacheProductos = obtenerCache(search);
		if(cacheProductos == null) {
			Page<Productos> paginacionProductos = productosDao.findByNombreProducto(PageRequest.of(page, size), search);
			agregarCache(paginacionProductos);
			return paginacionProductos;
		}else {
			return cacheProductos;
		}
		
	}
	
	private void agregarCache(Page<Productos> paginacion ) {
		System.out.println("Agrego cache");
			cache.save(paginacion);
		
	}
	
	private Page<Productos> obtenerCache(String search) {
		System.out.println("Listo cache");
		return  cache.findAll().get(search);
	}
	
	
	

}
