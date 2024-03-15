package com.sistema.erp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.sistema.erp.entidad.OrdenCompra;
import com.sistema.erp.service.OrdenCompraService;

@Controller
public class OrdenCompraController {
	
	final OrdenCompraService ordencompra;
	
	public OrdenCompraController(OrdenCompraService ordencompra) {
		this.ordencompra = ordencompra;
	}
	
	@GetMapping("/ordencompra/api")
	public ResponseEntity<Iterable<OrdenCompra>> index(){
		
		return ResponseEntity.ok(ordencompra.Load());
		
	}
}
