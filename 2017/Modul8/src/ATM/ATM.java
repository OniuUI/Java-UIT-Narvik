package ATM;

import java.util.*;

public class ATM {

	private static Scanner input = new Scanner(System.in);
	private static Account[] Accounts = new Account[10];
	private static int id;

	public static void main(String[] args) {
		for (int i = 0; i < Accounts.length; i++) {
			Accounts[i] = new Account(i + 1, 1000);

		}

		while (true) {
			askForID();
			int option = 0;
			while (option != 4) {
				System.out.printf("Meny %n1: Saldo %n2: Uttakk %n3: Innskudd %n4: Avbryt %nDitt Valg: ");
				option = getChoice();

				switch (option) {
				case 1:
					printBalance();
					break;
				case 2:
					withdraw();
					break;
				case 3:
					deposit();
					break;
				case 4:
					break;

				default:
					break;
				}

			}
		}
	}

	public static void askForID() {

		System.out.println("Oppgi konto id: ");
		id = input.nextInt();
		while (id > 10 || id < 0) {
			System.out.printf("Oppgi id mellom 1 og 10.\nOppgi konto id: ");
		}

	}

	static int getChoice() {
		return input.nextInt();
	}

	static void printBalance() {
		System.out.printf("%nSaldo for konto nr: %d er: %.2fkr, Konto opprettet: %tF %n%n", id, Accounts[id].getBalance(),
				Accounts[id].getDateCreated());

	}

	static void withdraw() {
		System.out.println("Oppgi uttaksverdi: ");
		int uttak = input.nextInt();
		System.out.printf((Accounts[id].withdraw(uttak) ? "%nTatt ut %dkr fra konto nr: %d %n%n" : "Ugyldig operasjon!"),
				uttak, (id));

	}

	static void deposit() {
		System.out.print("Oppgi innskudsverdi: ");
		int innskud = input.nextInt();
		System.out.printf(
				(Accounts[id].deposit(innskud) ? "%nSatt inn %dkr til konto nr: %d %n%n" : "Ugyldig operasjon!"), innskud,
				(id));

	}

}

class Account {
	int id;
	double Balance;
	static double AnnualInterestRate;
	Calendar dateCreated = Calendar.getInstance();

	public Account(int id, double Balance) {
		this.id = id;
		this.Balance = Balance;
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
