package com.santandertito.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.santandertito.exceptions.BankTransactionException;
import com.santandertito.model.BankAccountInfo;
import com.santandertito.model.Movimiento;
import com.santandertito.form.SendMoneyForm;
import com.santandertito.model.Movimiento;
import com.santandertito.repo.BankAccountDAO;
import com.santandertito.repo.MovimientoRepository;
import com.santandertito.repo.MovimientoRepository;

@RestController
public class MovimientoController {
	
	@Autowired
	MovimientoRepository repository;

	@GetMapping(value="/movimiento",  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Movimiento> getAll() {
		List<Movimiento> list = new ArrayList<>();
		Iterable<Movimiento> movimientos = repository.findAll();

		movimientos.forEach(list::add);
		return list;
	}

	@PostMapping(value="/postmovimiento")
	public Movimiento postMovimiento(@RequestBody Movimiento movimiento) {

		repository.save(new Movimiento(movimiento.getfechaMovimiento(), movimiento.getmontoMovimiento(), movimiento.getconceptoMovimiento(), movimiento.gettipoMovimientoId() ,movimiento.getstatusMovimiento(),movimiento.getchequeraId() ));
		return movimiento;
	}

	@GetMapping(value="/findbychequeraId/{chequeraId}",  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Movimiento> findBychequeraId(@PathVariable String chequeraId) {

		List<Movimiento> movimientos = repository.findBychequeraId(chequeraId);
		return movimientos;
	}

	@DeleteMapping(value="/movimiento/{id}")
	public void deleteMovimiento(@PathVariable long id){

		repository.deleteById(id);
	}
	
	
	
	
}