package dk.cphbusiness.banking.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class BaseBank implements Bank {
  private final Map<String, Account> accounts = new HashMap<>();
  private final String name;
  
  public BaseBank(String name) {
    this.name = name;
    }

  @Override
  public String getName() {
    return name;
    }

  @Override
  public Account findAccount(String number) {
    return accounts.get(number);
    }
  
  @Override
  public void addAccount(Account account) {
    accounts.put(account.getNumber(), account);
    }

  @Override
  public Collection<Account> listAccounts() {
    return accounts.values();
    }
  
  }
