package com.cg.banking.daoservices;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cg.banking.beans.Account;
import com.cg.banking.beans.Transaction;
public class AccountDAOImpl implements AccountDAO{
	private static Connection conn=GetConnection.getConnection();

	@Override
	public Account save(Account account) throws SQLException {
		try {
			conn.setAutoCommit(false);
			PreparedStatement pst=conn.prepareStatement("INSERT INTO Account12(accountNo,pinNumber,accountBalance,accountType,status) VALUES(accountNo.NEXTVAL,pinNo.NEXTVAL,?,?,?)");
			pst.setFloat(1,account.getAccountBalance());
			pst.setString(2, account.getAccountType());
			pst.setString(3,"Activated");

			pst.executeUpdate();

			PreparedStatement pst1=conn.prepareStatement("SELECT MAX(accountNo) from Account12");
			ResultSet rset=pst1.executeQuery();

			rset.next();
			long accountNo=rset.getLong(1);

			PreparedStatement pst2=conn.prepareStatement("SELECT MAX(pinNumber) from Account12");
			ResultSet rset1=pst2.executeQuery();

			rset1.next();
			int pinNumber=rset1.getInt(1);

			/*PreparedStatement ps1=conn.prepareStatement("INSERT INTO Transaction12(accountNo,transactionId,amount,transactionType) VALUES(?,transactionId.NEXTVAL,?,?)");
			ps1.setLong(1,accountNo);
			ps1.setFloat(2,account.getAccountBalance());
			ps1.setString(3,"Cash");
			ps1.executeUpdate();
			 */

			conn.commit();

			account.setAccountNo(accountNo);
			account.setPinNumber(pinNumber);

			return account;

		} catch (SQLException e) {
			conn.rollback();
			System.out.println("From DAO save method");
			e.printStackTrace();
			throw e;
		}
		finally{
			conn.setAutoCommit(true);
		}

	}

	@Override
	public Account creditAmount(long accountNo, float amount) {
		PreparedStatement ps1;
		try {
			ps1 = conn.prepareStatement("UPDATE Account12 SET accountBalance=((accountBalance)+?) WHERE accountNo="+accountNo);
			ps1.setFloat(1, amount);
			ps1.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("From credit of findone dao");
		}
		return findOne(accountNo);
	}


	@Override
	public Account extractAmount(long accountNo, float amount) {
		PreparedStatement ps1;
		try {
			ps1 = conn.prepareStatement("UPDATE Account12 SET accountBalance=((accountBalance)-?) WHERE accountNo="+accountNo);
			ps1.setFloat(1, amount);
			ps1.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("From credit of findone dao");
		}
		return findOne(accountNo);
	}

	@Override
	public Account findOne(long accountNo) {
		try {
			PreparedStatement ps=conn.prepareStatement("SELECT * FROM Account12 WHERE accountNo="+accountNo);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				int pinNumber=rs.getInt("pinNumber");
				float accountBalance=rs.getFloat("accountBalance");
				String accountType=rs.getString("accountType");
				String status=rs.getString("status");

				Account account=new Account(pinNumber, accountType, status, accountBalance, accountNo, null);
				return account;
			}
			return null;
		} catch (SQLException e) {
			System.out.println("From findOne exception");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Account> findAll() {
		try {
			List<Account> list=new ArrayList<Account>();
			PreparedStatement ps=conn.prepareStatement("SELECT * FROM Account12");
			ps.executeUpdate();

			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				long accountNo=rs.getLong("accountNo");
				int pinNumber=rs.getInt("pinNumber");
				float accountBalance=rs.getFloat("accountBalance");
				String accountType=rs.getString("accountType");
				String status=rs.getString("status");

				Account account=new Account(pinNumber, accountType, status, accountBalance, accountNo, null);
				list.add(account);
			}
			return list;

		} catch (SQLException e) {
			System.out.println("From findAll exception");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void saveTransactionForWithdraw(long accountNo, float amount) {
		try {
			PreparedStatement ps=conn.prepareStatement("INSERT INTO transaction12(accountNo,transactionId,amount,transactionType) VALUES(?,transactionId.NEXTVAL,?,?)");
			ps.setLong(1, accountNo);
			ps.setFloat(2, amount);
			ps.setString(3, "Withdraw");
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("From Save transaction of withdrwa");
		}
	}
	@Override
	public void saveTransactionForDeposit(long accountNo, float amount) {
		try {
			PreparedStatement ps=conn.prepareStatement("INSERT INTO transaction12(accountNo,transactionId,amount,transactionType) VALUES(?,transactionId.NEXTVAL,?,?)");
			ps.setLong(1, accountNo);
			ps.setFloat(2, amount);
			ps.setString(3, "Deposit");
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("From Save transaction of withdrwa");
		}

	}
	@Override
	public List<Transaction> getTransactionAll(long accountNo) {
		PreparedStatement ps;
		List<Transaction> list=new ArrayList<>();
		try {
			ps = conn.prepareStatement("SELECT transactionId,amount,transactionType FROM Transaction12 WHERE accountNo="+accountNo);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
			//	long accountNo=rs.getLong("");
				int transactionId=rs.getInt("transactionId");
				float amount=rs.getFloat("amount");
				String transactionType=rs.getString("transactionType");
				Transaction t=new Transaction(transactionId, amount, transactionType);
				list.add(t);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


}
