package com.sistema.erp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sistema.erp.entidad.Empleado;
import com.sistema.erp.repository.EmpleadoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmpleadoService {
		
	final EmpleadoRepository empleado;
	
	public EmpleadoService(EmpleadoRepository empleado) {
		this.empleado = empleado;
	}
	
	public Iterable<Empleado> load(){
		return empleado.findAll();
	}
	public long CountEmployee() {
		return empleado.count();
	}
}
