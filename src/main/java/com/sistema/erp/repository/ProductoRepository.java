package com.sistema.erp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sistema.erp.entidad.Producto;

@Repository
public interface ProductoRepository extends CrudRepository<Producto,Long> {

}
