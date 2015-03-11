package dk.cphbusiness.banking.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BaseAccount implements Account {
  private final String number;
  private final Bank bank;
  private final List<Movement> outgoing = new ArrayList<>();
  private final List<Movement> incoming = new ArrayList<>();

  public BaseAccount(String number, Bank bank) {
    this.number = number;
    this.bank = bank;
    bank.addAccount(this);
    }
  
  @Override
  public String getNumber() {
    return number;
    }

  @Override
  public Customer getCustomer() {
    throw new UnsupportedOperationException("Customer is not defined on internal accounts");
    }

  @Override
  public Bank getBank() {
    return bank;
    }
  
  @Override
  public int getBalance() {
    int balance = 0;
    for (Movement movement : outgoing) balance -= movement.getAmount();
    for (Movement movement : incoming) balance += movement.getAmount();
    return balance;
    }

  @Override
  public void transfer(String targetNumber, int amount)
      throws UnsufficientFundsException {
    Account target = bank.findAccount(targetNumber);
    Movement movement = new Movement(new Date(), amount, this, target);
    outgoing.add(movement);
    target.addIncoming(movement);
    }

  @Override
  public boolean isInternal() {
    return true;
    }

  @Override
  public void addOutgoing(Movement movement) {
    throw new UnsupportedOperationException("Not supported yet.");
    }

  @Override
  public void addIncoming(Movement movement) {
    incoming.add(movement);
    }
  
  }
