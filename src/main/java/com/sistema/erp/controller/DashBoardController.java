package com.sistema.erp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sistema.erp.service.ClienteService;
import com.sistema.erp.service.EmpleadoService;

@Controller
public class DashBoardController {
		
		final EmpleadoService srvempleado;
		final ClienteService srvcliente;
		
		public DashBoardController(EmpleadoService srvempleado,ClienteService srvcliente) {
			this.srvempleado = srvempleado;
			this.srvcliente = srvcliente;
		}
		
		@GetMapping("/")
		public String index(Model modelo) {
			
			var empleados = srvempleado.CountEmployee();
			var clientes = srvcliente.TotalClientes();
			modelo.addAttribute("empleados", empleados);
			modelo.addAttribute("clientes", clientes);
			return "dashboard";
		}
}
