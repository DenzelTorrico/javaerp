package com.sistema.erp.service;

import org.springframework.stereotype.Service;

import com.sistema.erp.entidad.Proveedor;
import com.sistema.erp.repository.ProveedorRepository;

@Service
public class ProveedorService {
		
		final ProveedorRepository proveedor;
	
		public ProveedorService(ProveedorRepository proveedor) {
			this.proveedor = proveedor;
		}
		public Iterable<Proveedor> Load(){
			return this.proveedor.findAll();
		}
		public void DeleteById(long id) {
			this.proveedor.deleteById(id);
		}
}
