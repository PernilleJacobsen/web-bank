package dk.cphbusiness.banking.model;

public class UnsufficientFundsException extends Exception {
  private final Account account;

  public UnsufficientFundsException(String message, Account account) {
    super(message);
    this.account = account;
    }

  public Account getAccount() {
    return account;
    }
  
  }
