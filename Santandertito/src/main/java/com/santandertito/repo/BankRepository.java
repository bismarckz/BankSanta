package com.santandertito.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.santandertito.model.Bank;


public interface BankRepository extends CrudRepository<Bank, Long> {
	List<Bank> findBybankNombre(String bankNombre);
	//public abstract List<Bank> findAll();
	//public abstract Bank findByidbancos(int idBanco);
}