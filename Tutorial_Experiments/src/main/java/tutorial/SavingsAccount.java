/**
 * 
 */
package tutorial;

/**
 * @author Gordon Fraser
 * 
 */
public class SavingsAccount extends BankAccount {

	/**
	 * @param owner
	 */
	public SavingsAccount(Owner owner) {
		super(owner);
	}

	/* (non-Javadoc)
	 * @see tutorial.BankAccount#deposit(int)
	 */
	@Override
	public void deposit(int amount) {
		balance += amount;
	}

	/* (non-Javadoc)
	 * @see tutorial.BankAccount#withdraw(int)
	 */
	@Override
	public boolean withdraw(int amount) {
		if (balance < amount) {
			return false;
		}

		balance -= amount;
		return true;
	}

}
