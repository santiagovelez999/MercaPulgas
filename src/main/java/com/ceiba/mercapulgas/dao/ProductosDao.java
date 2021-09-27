package com.ceiba.mercapulgas.dao;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.mercapulgas.dominio.Productos;

@Repository
public interface ProductosDao extends PagingAndSortingRepository<Productos, Integer>{
	
	public Page<Productos> findByNombreProducto(Pageable pageable, String nombreProducto);
}
