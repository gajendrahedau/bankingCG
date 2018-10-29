package com.cg.banking.daoservices;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import com.cg.banking.beans.Account;
import com.cg.banking.beans.Transaction;
public class AccountDAOImpl implements AccountDAO{
	private EntityManagerFactory factory=EntityManagerFactoryProvider.getEntityManagerFactory();

	@Override
	public Account save(Account account) {
		EntityManager entityManager=factory.createEntityManager();
		entityManager.getTransaction().begin();
		account.setStatus("Active");
		entityManager.persist(account);
		entityManager.getTransaction().commit();
		entityManager.close();
		return account;
	}

	@Override
	public Account creditAmount(long accountNumber, float amount) {
		EntityManager entityManager=factory.createEntityManager();
		entityManager.getTransaction().begin();
		Account account=findOne(accountNumber);
		account.setAccountBalance(account.getAccountBalance()+amount);
		entityManager.merge(account);
		entityManager.getTransaction().commit();
		entityManager.close();
		return account;
	}

	@Override
	public Account extractAmount(long accountNumber, float amount) {
		EntityManager entityManager=factory.createEntityManager();
		entityManager.getTransaction().begin();
		Account account=findOne(accountNumber);
		account.setAccountBalance(account.getAccountBalance()-amount);
		entityManager.merge(account);
		entityManager.getTransaction().commit();
		entityManager.close();
		return account;
	}

	@Override
	public Account findOne(long accountNumber) {
		EntityManager entityManager=factory.createEntityManager();
		return entityManager.find(Account.class, accountNumber);
	}

	@Override
	public List<Account> findAll() {
		EntityManager entityManager=factory.createEntityManager();
		Query query=entityManager.createNamedQuery("FindAll");
		return query.getResultList();
	}

	@Override
	public void saveTransaction(long accountNumber, float amount,String type) {
		EntityManager entityManager=factory.createEntityManager();
		entityManager.getTransaction().begin();
		Account account=findOne(accountNumber);
		Transaction transaction=new Transaction(amount, type, account);
		entityManager.persist(transaction);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	@Override
	public List<Transaction> getTransactionAll(long accountNumber) {
		EntityManager entityManager=factory.createEntityManager();
		Query query=entityManager.createNamedQuery("AllTransaction");
		query.setParameter("accountNumber", accountNumber);
		return query.getResultList();
	}

	@Override
	public void changeStatus(long accountNumber) {

	}
}
