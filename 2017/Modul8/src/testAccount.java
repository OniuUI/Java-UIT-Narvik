import java.util.*;

public class testAccount {

	public static void main(String[] args) {

		Account acc1 = new Account();
		acc1.setId(1121);
		acc1.setBalance(2000);
		acc1.setAnnualInterestRate(4.5);

		System.out.printf("Uttak av 2500kr fra konto: %s %nInnsettning av 3000kr: %s%n",
				(acc1.withdraw(2500) ? "Lykkes!" : "Feilet!"), (acc1.deposit(3000) ? "Lykkes!" : "Feilet!"));

		System.out.printf("Saldoen din er: %.2fkr %nMånedlig rente er %.2fkr %n", acc1.getBalance(),
				acc1.getMonthlyInterest());

		System.out.printf("Konto opprettet: %tF %1$tT %n", acc1.getDateCreated());

	}

}

class Account {
	int id;
	double Balance;
	static double AnnualInterestRate;
	Calendar dateCreated = Calendar.getInstance();

	Account() {
		this.id = 1;
		this.Balance = 1;
		Account.AnnualInterestRate = 1;

	}

	public double getAnnuaInterestRate() {

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

	public boolean withdraw(double withdraw) {
		boolean lykkes = (withdraw <= Balance && withdraw > 0);
		if (lykkes) {
			Balance -= withdraw;
		}
		return lykkes;
	}

	public boolean deposit(double deposit) {
		boolean lykkes = (deposit > 0);
		if (lykkes) {
			Balance += deposit;
		}
		return lykkes;
	}
}