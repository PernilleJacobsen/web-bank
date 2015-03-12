package dk.cphbusiness.banking.view;

import dk.cphbusiness.banking.control.BankManager;
import dk.cphbusiness.banking.control.BankManagerImplementation;
import dk.cphbusiness.banking.control.dto.CustomerDTO;
import dk.cphbusiness.banking.data.BankDataAccessor;
import dk.cphbusiness.banking.data.BankDataAccessorStub;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "BankServlet", urlPatterns = {"/Bank"})
public class BankServlet extends HttpServlet {
  private BankManager manager;

  // This is a singleton implementation :-)
  @Override
  public void init() throws ServletException {
    super.init();
    ServletContext application = getServletContext();
    manager = (BankManager)application.getAttribute("manager");
    if (manager == null) {
      BankDataAccessor data = new BankDataAccessorStub();
      manager = new BankManagerImplementation(data);
      application.setAttribute("manager", manager);
      }
    }
  
  @Override
  protected void service(
      HttpServletRequest request,
      HttpServletResponse response
      ) throws ServletException, IOException {
    HttpSession session = request.getSession();
    ServletContext application = getServletContext();
    
    String name = request.getParameter("name");

    int customerId = manager.createCustomer(name);
    Collection<CustomerDTO> customers = manager.listCustomers();
    
    request.setAttribute("customerId", customerId);
    request.setAttribute("customers", customers);
    request.getRequestDispatcher("show-customer.jsp").forward(request, response);
    }

  }
