package com.santandertito.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movimiento")
public class Movimiento implements Serializable {

	private static final long serialVersionUID = -3009157732242241606L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "fechamovimiento")
	private String fechaMovimiento;

	@Column(name = "montomovimiento")
	private float montoMovimiento;
	//
	@Column(name = "conceptomoviento")
	private String conceptoMovimiento;

	@Column(name = "tipomovimientoid")
	private String tipoMovimientoId;

	@Column(name = "chequeraid")
	private String chequeraId;

	@Column(name = "statusmovimiento")
	private String statusMovimiento;
	//
	
	//id
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
//FECHA`
	public String getfechaMovimiento() {
		return fechaMovimiento;
	}

	public void setfechaMovimiento(String fechaMovimiento) {
		this.fechaMovimiento = fechaMovimiento;
	}

//MONTO
	public float getmontoMovimiento() {
		return montoMovimiento;
	}

	public void setLastName(float montoMovimiento) {
		this.montoMovimiento = montoMovimiento;
	}

//CONCEPTO`
	public String getconceptoMovimiento() {
		return conceptoMovimiento;
	}

	public void setconceptoMovimiento(String conceptoMovimiento) {
		this.conceptoMovimiento = conceptoMovimiento;
	}

//TIPO MOVIMIENTO ID
	public String gettipoMovimientoId() {
		return tipoMovimientoId;
	}

	public void settipoMovimientoId(String tipoMovimientoId) {
		this.tipoMovimientoId = tipoMovimientoId;
	}

//CHEQUERA ID
	public String getchequeraId() {
		return chequeraId;
	}

	public void setchequeraId(String chequeraId) {
		this.chequeraId = chequeraId;
	}

	public String getstatusMovimiento() {
		return statusMovimiento;
	}

	public void setstatusMovimiento(String statusMovimiento) {
		this.statusMovimiento = statusMovimiento;
	}

	public Movimiento() {}

	public Movimiento(String fechaMovimiento, float montoMovimiento, String conceptoMovimiento, String tipoMovimientoId, String chequeraId, String statusMovimiento) {
		this.fechaMovimiento = fechaMovimiento;
		this.montoMovimiento = montoMovimiento;
		this.conceptoMovimiento = conceptoMovimiento;
		this.tipoMovimientoId = tipoMovimientoId;
		this.chequeraId = chequeraId;
		this.statusMovimiento = statusMovimiento;
	}

	@Override
	public String toString() {
		return String.format("Movimiento[id=%d, fechaMovimiento='%s', montoMovimiento='%s', conceptoMovimiento='%s', tipoMovimientoId='%s', chequeraId='%s', statusMovimiento='%s']", id, montoMovimiento, fechaMovimiento, conceptoMovimiento ,tipoMovimientoId ,chequeraId, statusMovimiento);
	}
}
