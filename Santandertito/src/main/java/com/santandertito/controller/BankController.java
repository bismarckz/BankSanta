package com.santandertito.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.santandertito.model.Bank;
import com.santandertito.repo.BankRepository;

@RestController
public class BankController {
	
	@Autowired
	BankRepository repository;

	@GetMapping(value="/bank",  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Bank> getAll() {
		List<Bank> list = new ArrayList<>();
		Iterable<Bank> banks = repository.findAll();

		banks.forEach(list::add);
		return list;
	}

	@PostMapping(value="/postbank")
	public Bank postBank(@RequestBody Bank bank) {

		repository.save(new Bank(bank.getbankNombre(), bank.getdireccionBank(), bank.getsucursalBank(), bank.gettelefonoBank(), bank.getstatusBank() ));
		return bank;
	}

	@GetMapping(value="/findbylastname/{bankNombre}",  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Bank> findByLastName(@PathVariable String bankNombre) {

		List<Bank> banks = repository.findBybankNombre(bankNombre);
		return banks;
	}

	@DeleteMapping(value="/bank/{id}")
	public void deleteBank(@PathVariable long id){

		repository.deleteById(id);
	}
}
