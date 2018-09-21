/**
 * 
 */
package tutorial;

/**
 * @author Gordon Fraser
 * 
 */
public class CurrentAccount extends BankAccount {

	private final int overdraftAllowance;

	/**
	 * @param owner
	 */
	public CurrentAccount(Owner owner, int overdraftAllowance) {
		super(owner);
		this.overdraftAllowance = overdraftAllowance;
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
		if (balance < (amount + overdraftAllowance)) {
			return false;
		}

		balance -= amount;
		return true;
	}

}
