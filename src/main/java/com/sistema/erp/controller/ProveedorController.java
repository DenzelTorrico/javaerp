package com.sistema.erp.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sistema.erp.entidad.Proveedor;
import com.sistema.erp.service.ProveedorService;

@Controller
public class ProveedorController {
		
	final ProveedorService servicio;
	
	public ProveedorController(ProveedorService servicio) {
		this.servicio = servicio;
	}
	
	@GetMapping("/proveedor")
	public String index(Model modelo) {
		modelo.addAttribute("proveedores", servicio.Load());
		return "proveedor/index";
	}
	@GetMapping("/proveedor/api")
	public ResponseEntity<Iterable<Proveedor>> getProveedores() {
		
	    return ResponseEntity.ok(servicio.Load());
	}
	
}
