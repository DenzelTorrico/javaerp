package com.sistema.erp.service;

import org.springframework.stereotype.Service;

import com.sistema.erp.entidad.OrdenCompra;
import com.sistema.erp.repository.OrdenCompraRepository;

@Service
public class OrdenCompraService {
		
		final OrdenCompraRepository orden_compra;
		
		public OrdenCompraService(OrdenCompraRepository ordencompra) {
			this.orden_compra = ordencompra;
		}
		
		public Iterable<OrdenCompra> Load(){
			return this.orden_compra.findAll();
		}
	
}
