package dk.cphbusiness.banking.view;

import dk.cphbusiness.banking.control.BankManager;
import dk.cphbusiness.banking.control.BankManagerImplementation;
import dk.cphbusiness.banking.control.dto.CustomerDTO;
import dk.cphbusiness.banking.data.BankDataAccessor;
import dk.cphbusiness.banking.data.BankDataAccessorStub;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "BankServlet", urlPatterns = {"/Bank"})
public class BankServlet extends HttpServlet {
  private BankManager manager;

  public BankServlet() {
    BankDataAccessor data = new BankDataAccessorStub();
    manager = new BankManagerImplementation(data);
    }
  
  @Override
  protected void service(
      HttpServletRequest request,
      HttpServletResponse response
      ) throws ServletException, IOException {
    String name = request.getParameter("name");

    int customerId = manager.createCustomer(name);
    Collection<CustomerDTO> customers = manager.listCustomers();
    
    request.setAttribute("customerId", customerId);
    request.setAttribute("customers", customers);
    request.getRequestDispatcher("show-customer.jsp").forward(request, response);
    }

  }
