package com.santandertito.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.santandertito.model.Movimiento;



public interface MovimientoRepository extends CrudRepository<Movimiento, Long> {
	List<Movimiento> findBychequeraId(String chequeraId);
}