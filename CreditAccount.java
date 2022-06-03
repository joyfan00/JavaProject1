// Joy Fan
// This is a class representing a credit account, giving the ability to the customer to borrow money

public class CreditAccount extends Account
{
  //interest rate
  private double interestRate = 0.0;
  
  //amount paid this month
  private double amountPaid = 0.0;
  
  //monthly payment
  private double monthlyPayment = 0.0;
  
  //constructor that initializes account number and interest rate 
  public CreditAccount (String accNum, double interestRate)
  {
    super (accNum, 0);
    this.interestRate = interestRate;
  }
  
  //set method for interest rate
  public void setInterestRate (double interestRate)
  {
    this.interestRate = interestRate;
  }
  
  //get method for interest rate
  public double getInterestRate ()
  {
    return interestRate;
  }
  
  //get method for monthly payment
  public double getMonthlyPayment ()
  {
    return monthlyPayment;
  }
  
  //get method for amount paid this month
  public double getAmountPaidThisMonth ()
  {
    return amountPaid;
  }
  
  //formulates monthly payment and amount paid at the end of the month
  public void endOfMonth ()
  {
    monthlyPayment = 0.9 * getBalance();
    if (getAmountPaidThisMonth () < getMonthlyPayment())
    {
      charge(getInterestRate () * (getBalance () / 12));
    }
    monthlyPayment = getBalance();
    amountPaid = 0;
  }
  
  //credit method that also adds to amount paid 
  @Override
  public void credit (double val)
  {
    super.credit(val);
    amountPaid = amountPaid + val;
  }
}