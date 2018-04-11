package com.santandertito.form;


public class SendCargoForm {
	 
    private long fromAccountId;
    private Double amount;
    
    private String nombreCliente;
    private String numCuenta;
    
    
 
    public SendCargoForm() {
 
    }
 
    public SendCargoForm(long fromAccountId,  Double amount) {
        this.fromAccountId = fromAccountId;
   
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