package zad1;

public class BankCustomer {
	Person person;
	Account account;

	public BankCustomer(Person person) {
		this.person = person;
		this.account = new Account();

	}

	public Account getAccount() {

		return this.account;
	}

	@Override
	public String toString() {
		return "Klient: " + person.name + " stan konta " + account.balance;
	}

}
