package oblig1;

public class Accounttest {

	public static void main(String[] args) {
		Account ac1 = new Account("Slim shady", 1, 2000);
		ac1.deposit(2000, "Helping a Friend");
		ac1.deposit(2500, "Selling TV");
		ac1.deposit(999, "Salery");
		ac1.withdraw(2300, "Buying Chainsaw");
		ac1.withdraw(750, "Getting Haircut");
		ac1.withdraw(2350, "Buying Expencive Clothing");
		ac1.setAnnualInterestRate(5.5);

		System.out.printf(
				"Name: %s%nAnnual interest rate: %.1f%nBalance: %.2f%n%nDate			Type		Amount		Balance		Description%n",
				ac1.getName(), ac1.getAnnualInterestRate(), ac1.getBalance());
		for (int i = 0; i < ac1.transaction.size(); i++) {
			System.out.println(ac1.transaction.get(i));
		}
	}

}