/*
 * Assessment: Lab 2
 * Student Name: Byron Jones
 * Due Date: 10/03/21
 * Description: A banking system that holds accounts, personal info, processes fees and interest
 * Professor Name: Dr. James Mwandi
 */
/*
 * Class that contains interest rate for a savings account
 */
public class Savings extends Account{
	private double interestRate;
	
	/*
	 * Constructor setting interest rate for a savings account
	 */
    public Savings() {
    	interestRate = 0.0399; // 3.99%
    }
    
    /*
     * Updates balance with interest
     */
    @Override
    public void updateBalance() {
    	super.updateBalance(); // // print statement with account number
    	balance += (interestRate / 12) * balance; // update balance with monthly interest rate
    }
}
