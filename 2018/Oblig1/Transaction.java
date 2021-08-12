package oblig1;

public class Transaction {
	double amount, balance;
	String description;
	java.util.GregorianCalendar dateCreated;
	char type;

	Transaction(char type, double amount, double balance, String description) {
		this.type = type;
		this.amount = amount;
		this.balance = balance;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public java.util.GregorianCalendar getDate() {
		dateCreated = new java.util.GregorianCalendar();
		return dateCreated;
	}

	public double getBalance() {
		return balance;
	}

	public double getAmount() {
		return amount;
	}

	public char getType() {
		return type;
	}

	public String toString() {
		return String.format("%tF %1$tT     %c    		%.2f		%.2f		%s", this.getDate(), this.getType(),
				this.getAmount(), this.getBalance(), this.getDescription());
	}
}
