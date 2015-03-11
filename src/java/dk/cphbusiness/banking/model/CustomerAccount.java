package dk.cphbusiness.banking.model;

public class CustomerAccount extends BaseAccount {
  private Customer customer;
  
  public CustomerAccount(String number, Bank bank, Customer customer) {
    super(number, bank);
    this.customer = customer;
    customer.addAccount(this);
    }

  @Override
  public boolean isInternal() {
    return false;
    }

  @Override
  public Customer getCustomer() {
    return customer;
    }

  }
