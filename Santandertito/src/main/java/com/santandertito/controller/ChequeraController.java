package com.santandertito.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;


import com.santandertito.model.Chequera;

import com.santandertito.repo.ChequeraRepository;

 
@RestController
public class ChequeraController {
        
	@Autowired
	ChequeraRepository repository;
	
		

	@GetMapping(value="/chequera",  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Chequera> getAll() throws Exception {
		List<Chequera> list = new ArrayList<>();
		Iterable<Chequera> chequeras = repository.findAll();
		chequeras.forEach(list::add);
		
		
		return list;
	}

	@PostMapping(value="/postchequera")
	public Chequera postChequera(@RequestBody Chequera chequera) {

		repository.save(new Chequera(chequera.getFechaChequera(), chequera.getClaveInter(), chequera.getNumCuenta(), chequera.getSaldoChequera(), chequera.getAbonoChequera(), chequera.getCargoChequera(), chequera.getCorteChequera(), chequera.getClienteid(),chequera.getBancoId()  ));
		return chequera;
	}

	@GetMapping(value="/findbynumCuenta/{numCuenta}",  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Chequera> findBynumCuenta(@PathVariable long numCuenta) throws Exception {

		
		List<Chequera> chequeras = (List<Chequera>) ChequeraRepository.findBynumCuenta(numCuenta);
		return chequeras;
	}
	
	/*
	@GetMapping(value="/crearPdf/{numCuenta}",  produces=MediaType.APPLICATION_JSON_VALUE)
	public Chequera crearPdf(@PathVariable long numCuenta) throws Exception {

		Map<String,String> data = new HashMap<>();
		 //Object chequeras;
			//List<Chequera> chequera = ChequeraRepository.findBynumCuenta(numCuenta);
		Chequera chequera = (Chequera) ChequeraRepository.findBynumCuenta(numCuenta);
		
		
	
	    data.put("fechaChequera",chequera.getFechaChequera());// .getFechaChequera());
	    data.put("claveInter",chequera.getClaveInter()); 
	    data.put("numCuenta",String.valueOf(chequera.getNumCuenta()));
	    data.put("saldoChequera",String.valueOf(chequera.getSaldoChequera()));
	    data.put("abonoChequera",String.valueOf(chequera.getAbonoChequera()));
	    data.put("cargoChequera",String.valueOf(chequera.getCargoChequera()));
	    data.put("corteChequera",String.valueOf(chequera.getCorteChequera()));
	    data.put("clienteId",String.valueOf(chequera.getClienteid()));
	    data.put("bancoId",String.valueOf(chequera.getBancoId()));
	  
	    pdfGenaratorUtil.createPdf("greeting",data);
		
	    
	    return chequera; 
		
	}*/

	@DeleteMapping(value="/chequera/{id}")
	public void deleteChequera(@PathVariable long id){

		repository.deleteById(id);
	}
}
