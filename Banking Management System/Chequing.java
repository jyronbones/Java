/*
 * Assessment: Lab 2
 * Student Name: Byron Jones
 * Due Date: 10/03/21
 * Description: A banking system that holds accounts, personal info, processes fees and interest
 * Professor Name: Dr. James Mwandi
 */
/*
 * Class that contains fees for chequing account
 */
public class Chequing extends Account{
	private double fees;

    /*
     * Constructor setting fees for a chequing account
     */
	public Chequing() {
    	fees = 13.50;
    }
    /*
     * Updates balance with fees
     */
    @Override
    public void updateBalance() {
    	super.updateBalance();
    	balance -= fees;
    }
}
