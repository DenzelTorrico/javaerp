package com.sistema.erp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sistema.erp.service.EmpleadoService;

@Controller
public class EmpleadoController {
	
	final EmpleadoService service;
	public EmpleadoController(EmpleadoService service) {
		this.service = service;
	}
	
	@GetMapping("/empleado")
	public String index(Model modelo) {
		modelo.addAttribute("empleados", service.load());
		return "empleado/index";
	}
}
