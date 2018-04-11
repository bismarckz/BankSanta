package com.santandertito.form;


public class SendMoneyForm {
	 
    private long fromAccountId;
    private long toAccountId;
    private Double amount;
    
    private String nombreCliente;
    private String numCuenta;
    
    
 
    public SendMoneyForm() {
 
    }
 
    public SendMoneyForm(long fromAccountId, long toAccountId, Double amount) {
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.amount = amount;
        //this.nombreCliente = nombreCliente;
        //this.numCuenta = numCuenta;
    }
 
    public long getFromAccountId() {
        return fromAccountId;
    }
 
    public void setFromAccountId(long fromAccountId) {
        this.fromAccountId = fromAccountId;
    }
 
    public long getToAccountId() {
        return toAccountId;
    }
 
    public void setToAccountId(long toAccountId) {
        this.toAccountId = toAccountId;
    }
 
    public Double getAmount() {
        return amount;
    }
 
    public void setAmount(Double amount) {
        this.amount = amount;
    }

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getNumCuenta() {
		return numCuenta;
	}

	public void setNumCuenta(String numCuenta) {
		this.numCuenta = numCuenta;
	}
    
    
}