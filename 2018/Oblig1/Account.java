package oblig1;

import java.util.ArrayList;
import java.util.Calendar;

class Account {
	ArrayList<Transaction> transaction = new ArrayList<>();
	int id;
	double Balance;
	static double AnnualInterestRate;
	String name;
	Calendar dateCreated = Calendar.getInstance();

	public Account(String name, int id, double Balance) {
		this.name = name;
		this.id = id;
		this.Balance = Balance;
		Account.AnnualInterestRate = 1;

	}

	public ArrayList<Transaction> getTransactions() {
		return transaction;

	}

	public double getAnnualInterestRate() {

		return AnnualInterestRate;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return Balance;
	}

	public String getName() {
		return name;
	}

	public void setBalance(double Balance) {
		this.Balance = Balance;
	}

	public Calendar getDateCreated() {

		return dateCreated;

	}

	public void setAnnualInterestRate(double AnnualInterestrate) {
		Account.AnnualInterestRate = AnnualInterestrate;
	}

	public double getMonthlyInterest() {
		return Balance * (AnnualInterestRate / 1200);
	}

	public void withdraw(double withdraw, String description) {

		boolean lykkes = (withdraw <= Balance && withdraw > -10000);
		if (lykkes) {
			Balance -= withdraw;
			transaction.add(new Transaction('W', withdraw, Balance, description));
			;

		}

	}

	public void deposit(double deposit, String description) {
		boolean lykkes = (deposit > -10000);
		if (lykkes) {
			Balance += deposit;
			transaction.add(new Transaction('D', deposit, Balance, description));
			;
		}

	}
}
