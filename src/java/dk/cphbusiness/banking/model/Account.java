package dk.cphbusiness.banking.model;

public interface Account {
  String getNumber();
  Bank getBank();
  Customer getCustomer();
  boolean isInternal();
  int getBalance();
  void transfer(String targetNumber, int amount)
      throws UnsufficientFundsException;
  void addOutgoing(Movement movement);
  void addIncoming(Movement movement);
  }
