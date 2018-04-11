	package com.santandertito.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "chequera")
public class Chequera implements Serializable {
	
	//  @Autowired
	//    private EntityManager entityManager;
	      

	private static final long serialVersionUID = -3009157732242241606L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "fechachequera")
	private String fechaChequera;

	@Column(name = "claveinter")		
	private String claveInter;
	//
	@Column(name = "numcuenta")
	private String numCuenta;

	@Column(name = "saldochequera")
	private double saldoChequera;

	@Column(name = "abonochequera")
	private double abonoChequera;
	
	@Column(name = "cargochequera")
	private double cargoChequera;

	@Column(name = "cortechequera")
	private int corteChequera;
	
	
	@Column(name = "clienteid")
	private long clienteId;

	@Column(name = "bancoid")
	private long bancoId;
	
	//
	protected Chequera() {
	}
	//id
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	
	public String getFechaChequera() {
		return fechaChequera;
	}
	public void setFechaChequera(String fechaChequera) {
		this.fechaChequera = fechaChequera;
	}
	public String getClaveInter() {
		return claveInter;
	}
	public void setClaveInter(String claveInter) {
		this.claveInter = claveInter;
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
	public double getAbonoChequera() {
		return abonoChequera;
	}
	public void setAbonoChequera(double abonoChequera) {
		this.abonoChequera = abonoChequera;
	}
	public double getCargoChequera() {
		return cargoChequera;
	}
	public void setCargoChequera(double cargoChequera) {
		this.cargoChequera = cargoChequera;
	}
	public int getCorteChequera() {
		return corteChequera;
	}
	public void setCorteChequera(int corteChequera) {
		this.corteChequera = corteChequera;
	}
	public long getClienteid() {
		return clienteId;
	}
	public void setClienteid(long clienteId) {
		this.clienteId = clienteId;
	}
	public long getBancoId() {
		return bancoId;
	}
	public void setBancoid(long bancoId) {
		this.bancoId = bancoId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Chequera(String fechaChequera, String claveInter, String numCuenta, double saldoChequera, double abonoChequera, double cargoChequera, int corteChequera, long bancoId, long clienteId) {
		this.fechaChequera = fechaChequera;
		this.claveInter = claveInter;
		this.numCuenta = numCuenta;
		this.saldoChequera = saldoChequera;
		this.abonoChequera = abonoChequera;
		this.cargoChequera = cargoChequera;
		this.corteChequera = corteChequera;
		this.bancoId = bancoId;
		this.clienteId = clienteId;
	}
	

	
}