package com.santandertito.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.santandertito.exceptions.BankTransactionException;
import com.santandertito.model.BankAccountInfo;
import com.santandertito.model.Chequera;
import com.santandertito.model.Movimiento;



	

@Repository
public interface ChequeraRepository extends CrudRepository<Chequera, Long> {

	static List<Chequera> findBynumCuenta(long numCuenta) {
	
		return null;
	}


	
}
	
	/*	
	static Chequera findBynumCuenta(String numCuenta) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public default List<BankAccountInfo> listBankAccountInfo() {
        String sql = "Select new " + BankAccountInfo.class.getName() //
                + "(e.id,e.fullName,e.balance) " //
                + " from " + Chequera.class.getName() + " e ";
        Query query = entityManager.createQuery(sql, BankAccountInfo.class);
        return query.getResultList();
    }
	
    // Do not catch BankTransactionException in this method.
    @Transactional(propagation = Propagation.REQUIRES_NEW, 
                        rollbackFor = BankTransactionException.class)
    public static void sendMoney(String fromAccountId, String toAccountId, double amount) throws BankTransactionException {
 
   //     addAmount(toAccountId, amount);
 //       addAmount(fromAccountId, -amount);
    
}
    
    // MANDATORY: Transaction must be created before.
    @Transactional(propagation = Propagation.MANDATORY )
    public static void addAmount(String toAccountId, double amount) throws BankTransactionException {
        Chequera account = findBynumCuenta(toAccountId);
        if (account == null) {
            throw new BankTransactionException("Account not found " + toAccountId);
        }
        double newBalance = account.getSaldoChequera() + amount;
        if (account.getSaldoChequera() + amount < 0) {
            throw new BankTransactionException(
                    "The money in the account '" + toAccountId + "' is not enough (" + account.getSaldoChequera() + ")");
        }
        account.setSaldoChequera(newBalance);
    }
}
/*

@Repository
public class ChequeraRepository {
	
	 @Autowired
	 private EntityManager entityManager;
	
 public ChequeraRepository() {}
 
}
@Autowired
    private EntityManager entityManager;

	 public Chequera findBynumCuenta(Long id) { 
	        return this.entityManager.find(Chequera.class, id);
	    }
	 
	 public List<Chequera> listBankAccountInfo() {
	        String sql = "Select new " + Chequera.class.getName() //
	                + "(e.id,e.fullName,e.balance) " //
	                + " from " + Chequera.class.getName() + " e ";
	        Query query = entityManager.createQuery(sql, Chequera.class);
	        return query.getResultList();
	    }
	
	  // MANDATORY: Transaction must be created before.
    @Transactional(propagation = Propagation.MANDATORY )
    public void addAmount(Long id, double amount) throws BankTransactionException {
        Chequera account = this.findBynumCuenta(id);
        if (account == null) {
            throw new BankTransactionException("Cuenta no encontrada " + id);
        }
        double newBalance = account.getSaldoChequera() + amount;
        if (account.getSaldoChequera() + amount < 0) {
            throw new BankTransactionException(
                    "El dinero de esta cuenta '" + id + "' no tiene suficiente saldo (" + account.getSaldoChequera() + ")");
        }
        account.setSaldoChequera(newBalance);
    }
 
  

	// Do not catch BankTransactionException in this method.
    @Transactional(propagation = Propagation.REQUIRES_NEW, 
                        rollbackFor = BankTransactionException.class)
    public void sendMoney(Long fromAccountId, Long toAccountId, double amount) throws BankTransactionException {
 
        addAmount(toAccountId, amount);
        addAmount(fromAccountId, -amount);
    }
*/