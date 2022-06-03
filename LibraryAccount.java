// Joy Fan
// This is a Library Account class that assesses the financial record of the library patron

public class LibraryAccount extends Account 
{
  //overdue book fine
  private double bookFine = 0.0;
  
  //overdue reserved fine
  private double reserveFine = 0.0;
  
  //number of overdue books
  private int overdueBooks = 0;
  
  //number of overdue reserved items
  private int overdueReserve = 0;
  
  //constructor that takes account number, balance limit, the overdue book fine, and the overdue reserve item fine
  public LibraryAccount (String accNum, int balanceLimit, double bookFine, double reserveFine)
  {
    super (accNum, balanceLimit);
    this.bookFine = bookFine;
    this.reserveFine = reserveFine;
  }
  
  //set method for book fine
  public void setBookFine (double bookFine)
  {
    this.bookFine = bookFine;
  }
  
  //get method for book fine
  public double getBookFine ()
  {
    return bookFine;
  }
  
  //set method for reserved item fine
  public void setReserveFine (double reserveFine)
  {
    this.reserveFine = reserveFine;
  }
  
  //get method for reserved item fine
  public double getReserveFine ()
  {
    return reserveFine;
  }
  
  //get method for overdue books
  public int getNumberOverdueBooks ()
  {
    return overdueBooks;
  }
  
  //increments the amount of overdue books by 1
  public void incrementOverdueBooks ()
  {
    overdueBooks = overdueBooks + 1;
  }
  
  //decrements the amount of overdue books by 1
  public void decrementOverdueBooks ()
  {
    overdueBooks = overdueBooks - 1;
    if (overdueBooks < 0)
    {
      overdueBooks = 0;
    }
  }
  
  //increment the amount of overdue reserved items by 1
  public void incrementOverdueReserve ()
  {
    overdueReserve = overdueReserve + 1;
  }
  
  //decrement the amount of overdue reserved items by 1
  public void decrementOverdueReserve ()
  {
    overdueReserve = overdueReserve - 1;
    if (overdueReserve < 0)
    {
      overdueReserve = 0;
    }
  }
  
  //get method for overdue reserved items
  public int getNumberOverdueReserve ()
  {
    return overdueReserve;
  }
  
  //boolean method for if account allows for patron to borrow books
  public boolean canBorrow ()
  {
    return getBalance () < getBalanceLimit ();
  }
  
  //end of day void boolean method 
  public void endOfDay ()
  {
    charge((getNumberOverdueBooks () * getBookFine ()) + (getNumberOverdueReserve () * getReserveFine ()));
  }
}