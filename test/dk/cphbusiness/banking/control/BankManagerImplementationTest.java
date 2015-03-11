package dk.cphbusiness.banking.control;

import dk.cphbusiness.banking.data.BankDataAccessor;
import dk.cphbusiness.banking.model.BaseCustomer;
import dk.cphbusiness.banking.model.Customer;
import static org.hamcrest.CoreMatchers.is;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Test;
import static org.junit.Assert.*;

public class BankManagerImplementationTest {
  public Mockery context = new JUnitRuleMockery();

  @Test
  public void setup() throws Exception {
    final BankDataAccessor data = context.mock(BankDataAccessor.class);
    // final Customer kurt = new BaseCustomer(7, "Kurt");
    final Customer kurt = context.mock(Customer.class);
    
    BankManager manager = new BankManagerImplementation(data);
    
    context.checking(new Expectations() {{
      oneOf(data).saveCustomer(with(any(Customer.class)));
      will(returnValue(kurt));
      
      oneOf(kurt).getId();
      will(returnValue(7));
      }} );
    
    int id = manager.createCustomer("Kurt");
    
    assertThat(id, is(7));
    }

  }
