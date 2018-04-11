package com.santandertito.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bank")
public class Bank implements Serializable {

	private static final long serialVersionUID = -3009157732242241606L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "banknombre")
	private String bankNombre;

	//
	@Column(name = "direccionbank")
	private String direccionBank;

	@Column(name = "sucursalbank")
	private String sucursalBank;

	@Column(name = "telefonobank")
	private String telefonoBank;

	@Column(name = "statusbank")
	private String statusBank;
//
	protected Bank() {
	}
	//id
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
//first name`
	public String getbankNombre() {
		return bankNombre;
	}

	public void setbankNombre(String bankNombre) {
		this.bankNombre = bankNombre;
	}

//lasname`
	public String getdireccionBank() {
		return direccionBank;
	}

	public void setdireccionBank(String direccionBank) {
		this.direccionBank = direccionBank;
	}

//sucursal
	public String getsucursalBank() {
		return sucursalBank;
	}

	public void setsucursalBank(String sucursalBank) {
		this.sucursalBank = sucursalBank;
	}

//RFC
	public String gettelefonoBank() {
		return telefonoBank;
	}

	public void settelefonoBank(String telefonoBank) {
		this.telefonoBank = telefonoBank;
	}


	//statuscliente
	public String getstatusBank() {
		return statusBank;
	}

	public void setstatusBank(String statusBank) {
		this.statusBank = statusBank;
	}

	public Bank(String bankNombre, String direccionBank, String sucursalBank, String telefonoBank, String statusBank) {
		this.bankNombre = bankNombre;
		this.direccionBank = direccionBank;
		this.sucursalBank = sucursalBank;
		this.telefonoBank = telefonoBank;
		this.statusBank = statusBank;
	}

	@Override
	public String toString() {
		return String.format("Customer[id=%d, bankNombre='%s', direccionBank='%s', sucursalBank='%s', telefonoBank='%s',statusBank='%s']", id, bankNombre, direccionBank, sucursalBank ,telefonoBank , statusBank);
	}
}
