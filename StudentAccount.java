// Joy Fan
// This is a class that is set up for a student's financial account record

public class StudentAccount extends Account
{
  //account name
  private String accName = "";
  
  //address of account holder
  private String address = "";
  
  //Library account object
  private LibraryAccount library = new LibraryAccount ("", 0, 0.0, 0.0);
  
  //Tuition credit object 
  private CreditAccount tuition = new CreditAccount ("", 0.0);
  
  //Dining credit object
  private CreditAccount dining = new CreditAccount ("", 0.0);
  
  //refund amount
  private double refundAmount = 0.0;
  
  //constructor, initializes account number and account name
  public StudentAccount (String accNum, String accName) 
  {
    super(accNum, 0);
    this.accName = accName;
  }
  
  //set method for accName
  public void setName (String accName) //passing along String to set name to
  {
    this.accName = accName;
  }
  
  //get method for accName
  public String getName ()
  {
    return accName;
  }
  
  //set method for account holder's address
  public void setAddress (String address) //passing along String to set address to
  {
    this.address = address;
  }
  
  //get method for account holder's address
  public String getAddress ()
  {
    return address;
  }
  
  //set method for library account
  public void setLibraryAccount (LibraryAccount library) //passing along LibraryAccount object l
  {
    this.library = library;
  }
  
  //get method for library account
  public LibraryAccount getLibraryAccount ()
  {
    return library;
  }
  
  //set method for tuition account 
  public void setTuitionAccount (CreditAccount tuition) //passing along CreditAccount object tuition
  {
    this.tuition = tuition;
  }
  
  //get method for tuition account
  public CreditAccount getTuitionAccount ()
  {
    return tuition;
  }
  
  //set method for dining account
  public void setDiningAccount (CreditAccount dining)
  {
    this.dining = dining;
  }
  
  //get method for dining account
  public CreditAccount getDiningAccount ()
  {
    return dining;
  }
  
  @Override
  //get method for balance that works different than regular account because accounts for tuition, dining, and
  //library financial records
  public double getBalance ()
  {
    return (library.getBalance() + tuition.getBalance() + dining.getBalance()) - refundAmount;

  }
  
  @Override
  //charge method to determine if the refund amount can 
  public void charge (double payment)
  {
    if (payment - refundAmount > 0)
    {
      tuition.charge(payment - refundAmount);
      refundAmount = 0.0;
    }
    else
    {
      refundAmount = refundAmount - payment;
    }
  }
  
  @Override
  //credit method to determine which account (tuition, dining, or library) payment should go towards
  public void credit (double payment)
  {
    if (tuition.getBalance() + dining.getBalance() + library.getBalance() <= payment)
    {
      payment = payment - tuition.getBalance();
      tuition.credit(tuition.getBalance());
      payment = payment - dining.getBalance();
      dining.credit(dining.getBalance());
      payment = payment - library.getBalance();
      library.credit(library.getBalance());
      refundAmount = payment;
    }
    else if (tuition.getBalance() + dining.getBalance() <= payment)
    {
      payment = payment - tuition.getBalance();
      tuition.credit(tuition.getBalance());
      payment = payment - dining.getBalance();
      dining.credit(dining.getBalance());
      library.credit(payment);
    }
    else if (tuition.getBalance() <= payment)
    {
      payment = payment - tuition.getBalance();
      tuition.credit(tuition.getBalance());
      dining.credit(payment);
    }
    else
    {
      tuition.credit(payment);
    }
    
  }
}