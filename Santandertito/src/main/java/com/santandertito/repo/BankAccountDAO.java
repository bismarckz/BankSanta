package com.santandertito.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.santandertito.exceptions.BankTransactionException;
import com.santandertito.model.BankAccountInfo;
import com.santandertito.model.Chequera;

@Repository
public class BankAccountDAO {

    @Autowired
    private EntityManager entityManager;


    public BankAccountDAO() {
    }

    public Chequera findById(long toAccountId) {
        return this.entityManager.find(Chequera.class, toAccountId);
    }

    public List<BankAccountInfo> listBankAccountInfo() {
        String sql = "Select new " + BankAccountInfo.class.getName() //
                + "(e.id,e.numCuenta,e.saldoChequera) " //
                + " from " + Chequera.class.getName() + " e ";
        Query query = entityManager.createQuery(sql, BankAccountInfo.class);
        return query.getResultList();
    }

    // Transaction
    @Transactional(propagation = Propagation.MANDATORY )
    public void addAmount(long toAccountId, double amount) throws BankTransactionException {
    	Chequera account = this.findById(toAccountId);
        if (account == null) {
            throw new BankTransactionException("Cuenta no encontrada " + toAccountId);
        }
        double newBalance = account.getSaldoChequera() + amount;
        if (account.getSaldoChequera() + amount < 0) {
            throw new BankTransactionException(
                    "La cuenta '" + toAccountId + "' no cuenta con dinero suficiente (" + account.getSaldoChequera() + ")");
        }
        account.setSaldoChequera(newBalance);
    }

    // BankTransactionException(Exception no) en este metodo
    @Transactional(propagation = Propagation.REQUIRES_NEW,
                        rollbackFor = BankTransactionException.class)
    public void sendMoney(long fromAccountId, long toAccountId, double amount) throws BankTransactionException {

        addAmount(toAccountId, amount);
        addAmount(fromAccountId, -amount);
    }

 // BankTransactionException(Exception no) en este metodo
    @Transactional(propagation = Propagation.REQUIRES_NEW,
                        rollbackFor = BankTransactionException.class)
    public void sendAbono(long toAccountId, double amount) throws BankTransactionException {

        addAmount(toAccountId, amount);
      
    }
    
 // BankTransactionException(Exception no) en este metodo
    @Transactional(propagation = Propagation.REQUIRES_NEW,
                        rollbackFor = BankTransactionException.class)
    public void sendCargo(long fromAccountId, double amount) throws BankTransactionException {
       
        addAmount(fromAccountId, -amount);
    }


}
