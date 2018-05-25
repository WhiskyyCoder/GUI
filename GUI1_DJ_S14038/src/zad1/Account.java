package zad1;

public class Account {

	double balance;
	public static double oprocentowanie;

	public void deposit(double deposit) {
		if (deposit > 0) {
			this.balance = this.balance + deposit;
		}

	}

	public void transfer(Account a, double amount) {
		if (a != null && amount > 0 && amount<=this.balance) {
			a.deposit(amount);
			this.balance=this.balance-amount;
		}
	}

	public void withdraw(int amount) {
		if (amount <= this.balance && amount >= 0) {
			this.balance = this.balance - amount;
		}

	}

	public static void setInterestRate(double x) {

		oprocentowanie = x;
	}

	public void addInterest() {

		deposit(this.balance * (oprocentowanie / 100));

	}

}
