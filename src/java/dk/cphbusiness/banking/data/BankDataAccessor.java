package dk.cphbusiness.banking.data;

import dk.cphbusiness.banking.model.Customer;
import java.util.Collection;

public interface BankDataAccessor {
//  static BankDataAccessor instance =
//      new BankDataAccessorStub();
  
  Customer saveCustomer(Customer customer);
  Customer findCustomer(int id);
  Collection<Customer> listCustomers();
  }
