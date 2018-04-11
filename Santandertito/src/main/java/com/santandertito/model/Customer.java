package com.santandertito.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {

	private static final long serialVersionUID = -3009157732242241606L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "firstname")
	private String firstName;

	@Column(name = "lastname")
	private String lastName;
	//
	@Column(name = "direccioncliente")
	private String direccionCliente;

	@Column(name = "rfccliente")
	private String rcfCliente;

	@Column(name = "razoncliente")
	private String razonCliente;

	@Column(name = "correocliente")
	private String correoCliente;

	@Column(name = "statuscliente")
	private String statusCliente;
//
	protected Customer() {
	}
	//id
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
//first name`
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

//lasname`
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

//direccion`
	public String getDireccionCliente() {
		return direccionCliente;
	}

	public void setDireccionCliente(String direccionCliente) {
		this.lastName = direccionCliente;
	}

//RFC
	public String getRcfCliente() {
		return rcfCliente;
	}

	public void setRcfCliente(String rcfCliente) {
		this.rcfCliente = rcfCliente;
	}

//Correo
	public String getCorreoCliente() {
		return correoCliente;
	}

	public void setCorreoCliente(String correoCliente) {
		this.correoCliente = correoCliente;
	}

	//statuscliente
	public String getStatusCliente() {
		return statusCliente;
	}

	public void setStatusCliente(String statusCliente) {
		this.statusCliente = statusCliente;
	}

	public Customer(String firstName, String lastName, String direccionCliente, String rfc, String correoCliente) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.direccionCliente = direccionCliente;
		this.rcfCliente = rfc;
		this.correoCliente = correoCliente;
	}

	@Override
	public String toString() {
		return String.format("Customer[id=%d, firstName='%s', lastName='%s', direccionCliente='%s', rfc='%s',correoCliente='%s',statuscliente='%s']", id, firstName, lastName);
	}
}
