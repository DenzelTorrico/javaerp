package com.sistema.erp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sistema.erp.entidad.Producto;
import com.sistema.erp.repository.ProductoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductoService {
		
	  private final ProductoRepository product;

		public ProductoService(ProductoRepository product) {
			this.product = product;
			
		}
		public Iterable<Producto> Load(){
			return product.findAll();
		}
		public void Guardar(Producto producto) {
			product.save(producto);
		}
}
