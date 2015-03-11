package dk.cphbusiness.banking.data;

import dk.cphbusiness.banking.model.BaseCustomer;
import dk.cphbusiness.banking.model.Customer;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class BankDataAccessorStub implements BankDataAccessor {
  private Map<Integer, Customer> customers = new HashMap<>();
  private int nextId = 1;

//  private static BankDataAccessor instance = null;
//  
//  private BankDataAccessorStub() {
//    }
//  
//  public static BankDataAccessor getInstance() {
//    if (instance == null) instance = new BankDataAccessorStub();
//    return instance;
//    }

  @Override
  public Customer saveCustomer(Customer customer) {
    if (customer.getId() == 0)
        customer = new BaseCustomer(nextId++, customer.getName());
    customers.put(customer.getId(), customer);
    return customer;
    }

  @Override
  public Customer findCustomer(int id) {
    return customers.get(id);
    }

  @Override
  public Collection<Customer> listCustomers() {
    return customers.values();
    }
  
  }
