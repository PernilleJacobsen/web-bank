package dk.cphbusiness.banking.data;

import dk.cphbusiness.banking.model.BaseCustomer;
import dk.cphbusiness.banking.model.Customer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class BankDataOracleAccessor implements BankDataAccessor {
  private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
  private static final String DB_URL = "jdbc:oracle:thin:@datdb.cphbusiness.dk:1521:DAT";
  private static final String USERNAME = "aka";
  private static final String PASSWORD = "aka";
  
  public BankDataOracleAccessor() throws ClassNotFoundException {
    Class.forName(DRIVER);
    }
  
  

  @Override
  public Customer saveCustomer(Customer customer) {
    try (Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
      connection.setAutoCommit(false);
      try {
        String sql = "insert into BANK_CUSTOMERS values (BANK_CUSTOMER_SEQUENCE.NEXTVAL, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, customer.getName());
        statement.executeUpdate();

        String sql2 = "select * from BANK_CUSTOMERS order by ID desc";
        PreparedStatement statement2 = connection.prepareStatement(sql2);
        ResultSet results = statement2.executeQuery();
        BaseCustomer result = null;
        if (results.next()) {
          result = new BaseCustomer(results.getInt("ID"), results.getString("NAME"));
          }
        connection.commit();
        return customer;
        }
      catch (SQLException sqle) {
        System.err.println(sqle);
        connection.rollback();
        return null;
        }
      }
    catch (SQLException sqle) {
      System.err.println(sqle);
      return null;
      }
    }

  @Override
  public Customer findCustomer(int id) {
    throw new UnsupportedOperationException("Not supported yet.");
    }

  @Override
  public Collection<Customer> listCustomers() {
    try (Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
      Collection<Customer> customers = new ArrayList<>();
      String sql = "select * from BANK_CUSTOMERS order by ID";
      PreparedStatement statement = connection.prepareStatement(sql);
      ResultSet results = statement.executeQuery();
      while (results.next()) {
        customers.add(new BaseCustomer(results.getInt("ID"), results.getString("NAME")));
        }
      return customers;
      }
    catch (SQLException sqle) {
      System.err.println(sqle);
      return null;
      }
    }
  
  }
