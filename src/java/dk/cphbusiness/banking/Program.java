package dk.cphbusiness.banking;

import dk.cphbusiness.banking.control.BankManager;
import dk.cphbusiness.banking.control.BankManagerImplementation;
import dk.cphbusiness.banking.data.BankDataAccessor;
import dk.cphbusiness.banking.data.BankDataAccessorStub;
import dk.cphbusiness.banking.data.BankDataOracleAccessor;
import dk.cphbusiness.banking.view.BankConsole;

public class Program {
  
  public static void main(String[] args) throws Exception {
    // BankDataAccessor data = new BankDataAccessorStub();
    BankDataAccessor data = new BankDataOracleAccessor();
    BankManager manager = new BankManagerImplementation(data);
    BankConsole console = new BankConsole(manager);
    console.run();
    }
  
  }
