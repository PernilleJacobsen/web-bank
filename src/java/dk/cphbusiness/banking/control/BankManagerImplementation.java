package dk.cphbusiness.banking.control;

import dk.cphbusiness.banking.control.dto.CustomerDTO;
import dk.cphbusiness.banking.data.BankDataAccessor;
import dk.cphbusiness.banking.model.Account;
import dk.cphbusiness.banking.model.BaseCustomer;
import dk.cphbusiness.banking.model.Customer;
import java.util.ArrayList;
import java.util.Collection;

public class BankManagerImplementation implements BankManager {
  private BankDataAccessor data;
  
  public BankManagerImplementation(BankDataAccessor data) {
    this.data = data;
    }

  @Override
  public int createCustomer(String name) {
    Customer customer = new BaseCustomer(0, name);
//    customer = BankDataAccessorStub.getInstance().saveCustomer(customer);
//    customer = BankDataAccessor.instance.saveCustomer(customer);
    customer = data.saveCustomer(customer);
    return customer.getId();
    }

  @Override
  public String createAccount(int customerId) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  @Override
  public boolean transferAmount(String sourceNumber, String targetNumber, int amount) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  private CustomerDTO createCustomerDTO(Customer customer) {
    int balance = 0;
    for (Account account : customer.listAccounts())
        balance += account.getBalance();
    return new CustomerDTO(
        customer.getId(),
        customer.getName(), 
        balance
        );
    }
  
  @Override
  public Collection<CustomerDTO> listCustomers() {
    Collection<CustomerDTO> dtos = new ArrayList<>();
    for (Customer customer : data.listCustomers()) {
      dtos.add(createCustomerDTO(customer));
      }
    return dtos;
    }
  
  }
