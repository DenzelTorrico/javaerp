package com.sistema.erp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sistema.erp.entidad.Empleado;

public interface EmpleadoRepository extends CrudRepository<Empleado,Long> {

}
