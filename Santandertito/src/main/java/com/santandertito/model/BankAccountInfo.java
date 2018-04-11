package com.santandertito.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
//@Table(name = "bankaccouninfo")
public class BankAccountInfo {
	 
	//@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	   private Long id;
	
	//@Column(name = "fullname")
	   private String numCuenta;
	
//	@Column(name = "balance")
	   private double saldoChequera;
	 
	   public BankAccountInfo() {
	 
	   }
	 
	   // Used in JPA query.
	   public BankAccountInfo(Long id, String numCuenta, double saldoChequera) {
	      this.id = id;
	      this.numCuenta = numCuenta;
	      this.saldoChequera = saldoChequera;
	   }
	 
	   public Long getId() {
	      return id;
	   }
	 
	   public void setId(Long id) {
	      this.id = id;
	   }
	 
	   public String getNumCuenta() {
	      return numCuenta;
	   }
	 
	   public void setNumCuenta(String numCuenta) {
	      this.numCuenta = numCuenta;
	   }
	 
	   public double getSaldoChequera() {
	      return saldoChequera;
	   }
	 
	   public void setSaldoChequera(double saldoChequera) {
	      this.saldoChequera = saldoChequera;
	   }
	}