// Joy Fan
// This is the bank account class that records an amount for how much an individual owes 

public class Account 
{
  //account number
  private String accNum = "";
  
  //balance limit
  private int balanceLimit = 0;
  
  //balance
  private double balance = 0.0;
  
  public Account ()
  {
  }
  //constructor that initializes account number and balance limit
  public Account (String accNum, int balanceLimit)
  {
    this.accNum = accNum;
    this.balanceLimit = balanceLimit;
  }
  
  //get method for account number
  public String getAccountNumber ()
  {
    return accNum;
  }
  
  //get method for balance
  public double getBalance ()
  {
    return balance;
  }
  
  //charges money to the balance
  public void charge (double val)
  {
    balance = balance + val;
  }
  
  //credits money to the balance
  public void credit (double val)
  {
    balance = balance - val;
  }
  
  //set method to the balance limit
  public void setBalanceLimit (int balanceLimit)
  {
    this.balanceLimit = balanceLimit;
  }
  
  //get method to the balance limit
  public int getBalanceLimit ()
  {
    return balanceLimit;
  }
}