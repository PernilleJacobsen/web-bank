package dk.cphbusiness.banking.control;

import dk.cphbusiness.banking.control.dto.CustomerDTO;
import java.util.Collection;

public interface BankManager {
  int createCustomer(String name);
  Collection<CustomerDTO> listCustomers();
  String createAccount(int customerId);
  boolean transferAmount(String sourceNumber, String targetNumber, int amount);
  }
