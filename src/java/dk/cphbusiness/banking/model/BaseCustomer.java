package dk.cphbusiness.banking.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class BaseCustomer implements Customer {
  private int id;
  private String name;
  private Map<String, Account> accounts = new HashMap<>();
  
  public BaseCustomer(int id, String name) {
    this.id = id;
    this.name = name;
    }
  
  @Override
  public int getId() {
    return id;
    }

  @Override
  public String getName() {
    return name;
    }

  @Override
  public Collection<Account> listAccounts() {
    return accounts.values();
    }

  @Override
  public Account findAccount(String number) {
    return accounts.get(number);
    }

  @Override
  public void addAccount(Account account) {
    accounts.put(account.getNumber(), account);
    }
  
  }
