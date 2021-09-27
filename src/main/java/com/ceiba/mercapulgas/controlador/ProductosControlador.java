package com.ceiba.mercapulgas.controlador;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.mercapulgas.dominio.Productos;
import com.ceiba.mercapulgas.service.ProductosServicioImpl;

@RestController
@RequestMapping("/productos")
public class ProductosControlador {
	
	@Autowired
	ProductosServicioImpl productosServicioImpl;
	
	@GetMapping()
	@CrossOrigin("http://localhost:4200")
	public Page<Productos> getProductos(@RequestParam  int page, @RequestParam  int size, @RequestParam  String search){
		if(search.isEmpty()) {
			return productosServicioImpl.getProductos(page, size);
		}else {
			return productosServicioImpl.search(page, size, search);
		}
	}
}
