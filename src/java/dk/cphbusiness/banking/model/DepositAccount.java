package dk.cphbusiness.banking.model;

public class DepositAccount extends CustomerAccount {

  public DepositAccount(String number, Bank bank, Customer customer) {
    super(number, bank, customer);
    }

  @Override
  public void transfer(String targetNumber, int amount) throws UnsufficientFundsException {
    if (amount > getBalance()) throw new UnsufficientFundsException("No funds", this);
    super.transfer(targetNumber, amount);
    }
  
  }
